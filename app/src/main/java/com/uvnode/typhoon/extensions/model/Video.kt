package com.uvnode.typhoon.extensions.model

data class Video(val uri: String, val name: String, val format: Int) {
    companion object {
        const val FORMAT_MP4 = 1
        const val FORMAT_DASH = 2
        const val FORMAT_HLS = 3
    }
}