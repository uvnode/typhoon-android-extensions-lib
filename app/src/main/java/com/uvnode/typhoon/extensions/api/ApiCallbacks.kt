package com.uvnode.typhoon.extensions.api

interface ApiCallbacks {
    fun onFailure(error: ApiError)
    fun onResponse(response: ApiResponse?)
}