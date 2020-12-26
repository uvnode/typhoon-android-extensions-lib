package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.api.ApiCallbacks
import com.uvnode.typhoon.extensions.model.Listing
import com.uvnode.typhoon.extensions.model.Series

interface HasListings {
    @Throws(Exception::class)
    fun getListings(apiConsumer: ApiCallbacks, series: Series)

    @Throws(Exception::class)
    fun getEpisodesList(apiConsumer: ApiCallbacks, series: Series, listing: Listing)
}