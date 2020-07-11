package com.uvnode.typhoon.extensions.executor;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

public class JSEClient {

    private Context context;
    private JSEInnerClient client;
    private WebView webView;
    private HashMap<String, BrowserEventCallback> callbacksMaps;

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
    }

    public String getUserAgent() {
        return webView.getSettings().getUserAgentString();
    }

    private void loadUrl(final String url) {
        Handler mainHandler = new Handler(this.context.getMainLooper());
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
        callbacksMaps.put(event.url, callback);
        loadUrl(event.url);
    }

    public void inForeground() {
    }

    class HtmlAccessor {
        @JavascriptInterface
        public void getHtml(String html, String url) {
            JSEResponseEvent jseResponseEvent = new JSEResponseEvent();
            jseResponseEvent.url = url;
            jseResponseEvent.data = html;

//            EventBus.getDefault().postSticky(jseResponseEvent);
            callbacksMaps.get(url).onReceive(jseResponseEvent);
        }
    }

    public class JSEResponseEvent {
        public String url, data;

        public final void complete() {
            callbacksMaps.remove(url);
            webView.loadUrl("about:blank");
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
                Log.e("page-finished", url);
            }
        }

        public void setDelayType(int delayType) {
            this.delayType = delayType;
        }
    }
}
