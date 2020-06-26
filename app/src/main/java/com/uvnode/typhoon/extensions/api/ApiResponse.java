package com.uvnode.typhoon.extensions.api;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ApiResponse {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({UNCHANGED, NEW, UPDATE})
    public @interface Result {}

    public static final int UNCHANGED = 0;
    public static final int NEW = 1;
    public static final int UPDATE = 2;

    private Object payload;
    private int responseResult;

    public ApiResponse(int result) {
        this.responseResult = result;
    }

    public int getResult() {
        return responseResult;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
