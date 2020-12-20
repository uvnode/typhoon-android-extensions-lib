package com.uvnode.typhoon.extensions.executor;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;

public class JSEClient {

    private static final String TAG = "JSEClient";

    private Context context;
    private JSEInnerClient client;
    private WebView webView;
    private Handler mainHandler;
    private HashMap<String, BrowserEventCallback> callbacksMaps;

    private String userAgent;

    public JSEClient(Context context) {
        this.context = context;
        this.client = new JSEInnerClient();
        this.callbacksMaps = new HashMap<>();
        this.webView = new WebView(this.context);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setWebViewClient(this.client);

//        EventBus.getDefault().register(this);

        this.webView.addJavascriptInterface(new HtmlAccessor(), "HtmlAccessor");
        this.userAgent = webView.getSettings().getUserAgentString();
        this.mainHandler = new Handler(this.context.getMainLooper());
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void reset() {
        webView.clearCache(true);
        webView.clearHistory();

        CookieManager cookieManager = CookieManager.getInstance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(new ValueCallback<Boolean>() {
                // a callback which is executed when the cookies have been removed
                @Override
                public void onReceiveValue(Boolean aBoolean) {
                    Log.d(TAG, "Cookie removed: " + aBoolean);
                }
            });
        }
        else cookieManager.removeAllCookie();

        WebStorage.getInstance().deleteAllData();
    }

    private void loadUrl(final String url) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        });
    }

    public static class BrowserEvent {
        public String url;
    }

    public interface BrowserEventCallback {
        void onReceive(JSEResponseEvent event);
    }

    public void inBackground(BrowserEventCallback callback, BrowserEvent event) {
        String key = getUrlKey(event.url);
        callbacksMaps.put(key, callback);
        loadUrl(event.url);
        Log.d(TAG, "inBackground: " + event.url);
    }

    public void inForeground() {
    }

    private String getUrlKey(String url) {
        Uri uri = Uri.parse(url);
        String key = uri.getAuthority() + uri.getPath();

        return key;
    }

    class HtmlAccessor {
        @JavascriptInterface
        public void getHtml(String html, String url) {
            JSEResponseEvent jseResponseEvent = new JSEResponseEvent();
            jseResponseEvent.url = url;
            jseResponseEvent.data = html;

//            EventBus.getDefault().postSticky(jseResponseEvent);
            callbacksMaps.get(getUrlKey(url)).onReceive(jseResponseEvent);
        }
    }

    public class JSEResponseEvent {
        public String url, data;

        public final void complete() {
            callbacksMaps.remove(getUrlKey(url));
            loadUrl("about:blank");
        }
    }

    static class JSEInnerClient extends WebViewClient {

        private int delayType = 0;

        public JSEInnerClient() {
            delayType = 0;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(!"about:blank".equals(url)) {
                view.loadUrl("javascript:HtmlAccessor.getHtml('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>', '" + url + "')");
                Log.d(TAG, "onPageFinished: " + url);
            }
        }

        public void setDelayType(int delayType) {
            this.delayType = delayType;
        }
    }
}
