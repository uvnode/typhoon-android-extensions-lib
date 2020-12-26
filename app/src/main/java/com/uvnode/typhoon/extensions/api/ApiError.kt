package com.uvnode.typhoon.extensions.api

class ApiError {
    var message: String?
        private set

    constructor(message: String?) {
        this.message = message
    }

    constructor(e: Throwable) {
        message = e.message
    }
}