package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.api.ApiCallbacks
import com.uvnode.typhoon.extensions.model.Episode
import com.uvnode.typhoon.extensions.model.Series
import com.uvnode.typhoon.extensions.model.Source

abstract class MetaSource {
    var isEnabled = false
    @Throws(Exception::class)
    abstract fun getSeries(callbacks: ApiCallbacks, series: Series)
    @Throws(Exception::class)
    abstract fun getSeriesList(callbacks: ApiCallbacks)
    @Throws(Exception::class)
    abstract fun getEpisode(callbacks: ApiCallbacks, episode: Episode)
    @Throws(Exception::class)
    abstract fun getEpisodesList(callbacks: ApiCallbacks, series: Series)
    @Throws(Exception::class)
    abstract fun getVideoUris(callbacks: ApiCallbacks, series: Series, episode: Episode)
    abstract val source: Source?
}