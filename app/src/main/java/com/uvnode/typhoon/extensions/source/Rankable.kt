package com.uvnode.typhoon.extensions.source

import com.uvnode.typhoon.extensions.api.ApiCallbacks
import com.uvnode.typhoon.extensions.model.Ranking

interface Rankable {
    @Throws(Exception::class)
    fun getRankings(callbacks: ApiCallbacks?)

    @Throws(Exception::class)
    fun getSeriesList(callbacks: ApiCallbacks, ranking: Ranking)
}