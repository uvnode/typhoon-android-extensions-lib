package com.uvnode.typhoon.extensions.api;

public class ApiSuccess {

    private Object payload;

    public ApiSuccess(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }
}
