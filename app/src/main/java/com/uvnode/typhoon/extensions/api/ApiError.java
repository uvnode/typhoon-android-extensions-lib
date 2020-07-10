package com.uvnode.typhoon.extensions.api;

public class ApiError {

    private String message;

    public ApiError(String message) {
        this.message = message;
    }

    public ApiError(Throwable e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
