package com.uvnode.typhoon.extensions.api

class ApiResponse(val result: Int) {
    private var payload: Any? = null
    fun get(): Any? {
        return payload
    }

    fun set(payload: Any?) {
        this.payload = payload
    }

    companion object {
        const val NONE = 0
        const val SOME = 1
    }
}