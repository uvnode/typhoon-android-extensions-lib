package com.uvnode.typhoon.extensions.api;

public class ApiResponse {

    public static final int NONE = 0;
    public static final int SOME = 1;

    private Object payload;
    private int responseResult;

    public ApiResponse(int result) {
        this.responseResult = result;
    }

    public int getResult() {
        return responseResult;
    }

    public Object get() {
        return payload;
    }

    public void set(Object payload) {
        this.payload = payload;
    }
}
