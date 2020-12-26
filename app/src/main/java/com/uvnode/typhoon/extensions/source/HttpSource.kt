package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.executor.JSEClient
import okhttp3.OkHttpClient

abstract class HttpSource : MetaSource(), Rankable, Filterable {
    var okClient: OkHttpClient? = null
    var jseClient: JSEClient? = null
        private set

    fun setJSEClient(jseClient: JSEClient?) {
        this.jseClient = jseClient
    }
}