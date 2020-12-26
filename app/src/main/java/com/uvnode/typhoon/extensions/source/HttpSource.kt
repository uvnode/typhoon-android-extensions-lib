package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.executor.JSEClient
import okhttp3.OkHttpClient

abstract class HttpSource : MetaSource(), Rankable, Filterable {
    open var okClient: OkHttpClient? = null
    open var jseClient: JSEClient? = null
}