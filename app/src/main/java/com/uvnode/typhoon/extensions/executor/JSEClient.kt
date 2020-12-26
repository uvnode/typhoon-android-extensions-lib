package com.uvnode.typhoon.extensions.executor

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.util.Log
import android.webkit.*
import com.uvnode.typhoon.extensions.api.ApiResponse
import java.util.*

class JSEClient(private val context: Context) {
    private val client: JSEInnerClient
    private val webView: WebView
    private val mainHandler: Handler
    private val callbacksMaps: HashMap<String, BrowserEventCallback>
    val userAgent: String
    fun reset() {
        webView.clearCache(true)
        webView.clearHistory()
        val cookieManager = CookieManager.getInstance()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies { aBoolean ->
                // a callback which is executed when the cookies have been removed
                Log.d(TAG, "Cookie removed: $aBoolean")
            }
        } else cookieManager.removeAllCookie()
        WebStorage.getInstance().deleteAllData()
    }

    private fun loadUrl(url: String?) {
        mainHandler.post { webView.loadUrl(url) }
    }

    class BrowserEvent {
        var url: String? = null
    }

    interface BrowserEventCallback {
        fun onReceive(event: JSEResponseEvent?)
    }

    fun inBackground(callback: BrowserEventCallback, event: BrowserEvent) {
        val key = getUrlKey(event.url)
        callbacksMaps[key] = callback
        loadUrl(event.url)
        Log.d(TAG, "inBackground: " + event.url)
    }

    fun inForeground() {}
    private fun getUrlKey(url: String?): String {
        val uri = Uri.parse(url)
        return uri.authority + uri.path
    }

    internal inner class HtmlAccessor {
        @JavascriptInterface
        fun getHtml(html: String?, url: String?) {
            val jseResponseEvent = JSEResponseEvent()
            jseResponseEvent.url = url
            jseResponseEvent.data = html

//            EventBus.getDefault().postSticky(jseResponseEvent);
            callbacksMaps[getUrlKey(url)]!!.onReceive(jseResponseEvent)
        }
    }

    inner class JSEResponseEvent {
        var url: String? = null
        var data: String? = null
        fun complete() {
            callbacksMaps.remove(getUrlKey(url))
            loadUrl("about:blank")
        }
    }

    internal class JSEInnerClient : WebViewClient() {
        private var delayType = 0
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            if ("about:blank" != url) {
                view.loadUrl("javascript:HtmlAccessor.getHtml('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>', '$url')")
                Log.d(TAG, "onPageFinished: $url")
            }
        }

        fun setDelayType(delayType: Int) {
            this.delayType = delayType
        }

        init {
            delayType = 0
        }
    }

    companion object {
        private const val TAG = "JSEClient"
    }

    init {
        client = JSEInnerClient()
        callbacksMaps = HashMap()
        webView = WebView(context)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = client

//        EventBus.getDefault().register(this);
        webView.addJavascriptInterface(HtmlAccessor(), "HtmlAccessor")
        userAgent = webView.settings.userAgentString
        mainHandler = Handler(context.mainLooper)
    }
}