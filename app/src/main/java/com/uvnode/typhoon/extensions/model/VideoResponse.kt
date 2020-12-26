package com.uvnode.typhoon.extensions.model

class VideoResponse(val uris: List<Video>, val isSuccess: Boolean) : WatchableResponse {
    var errorCode = 0
    var backupUri = ""

    companion object {
        const val ERROR_UNKNOWN = 0
        const val ERROR_TIMEOUT = 1
        const val ERROR_SOURCE_NOT_FOUND = 2
        const val ERROR_LINKS_NOT_FOUND = 3
    }
}