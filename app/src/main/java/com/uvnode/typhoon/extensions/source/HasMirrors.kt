package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.api.ApiCallbacks
import com.uvnode.typhoon.extensions.model.Episode
import com.uvnode.typhoon.extensions.model.Mirror
import com.uvnode.typhoon.extensions.model.Series

interface HasMirrors {
    @Throws(Exception::class)
    fun getVideoUris(callbacks: ApiCallbacks, series: Series, episode: Episode, mirror: Mirror)
}