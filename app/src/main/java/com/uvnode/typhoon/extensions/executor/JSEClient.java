package com.uvnode.typhoon.extensions.executor;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class JSEClient {

    private Context context;
    private JSEInnerClient client;
    private WebView webView;

    public JSEClient(Context context) {
        this.context = context;
        this.client = new JSEInnerClient();
        this.webView = new WebView(this.context);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setWebViewClient(this.client);

        EventBus.getDefault().register(this);
    }

    public String getUserAgent() {
        return webView.getSettings().getUserAgentString();
    }

    public void loadUrl(final String url) {
        Handler mainHandler = new Handler(this.context.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        });

    }

    public static class BrowserEvent {
    }

    @Subscribe
    public void onBrowserEvent(BrowserEvent event) {
        Log.e("browser-event", "browser");
    }

    public void inBackground() {

    }

    public void inForeground() {

    }
}

class JETransmissionEvent {
    public String data;
}

class JSEInnerClient extends WebViewClient {

    private int delayType = 0;

    public JSEInnerClient() {
       delayType = 0;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if(!"about:blank".equals(url)) {
            view.loadUrl("javascript:HtmlAccessor.getHtml('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>')");
            Log.e("page-finished", url);
        }
    }

    public void setDelayType(int delayType) {
        this.delayType = delayType;
    }
}