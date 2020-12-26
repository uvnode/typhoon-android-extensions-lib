package com.uvnode.typhoon.extensions.api

data class ApiResponse(val result: Int, var payload: Any?) {
    companion object {
        const val NONE = 0
        const val SOME = 1
    }
}