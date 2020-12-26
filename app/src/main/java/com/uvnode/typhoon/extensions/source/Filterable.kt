package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.api.ApiCallbacks
import com.uvnode.typhoon.extensions.model.Filter

interface Filterable {
    val filters: List<Filter<*>?>?

    @Throws(Exception::class)
    fun search(callbacks: ApiCallbacks, filters: List<Filter<*>?>, page: Int)
}