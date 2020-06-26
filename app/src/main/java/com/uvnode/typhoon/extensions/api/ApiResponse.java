package com.uvnode.typhoon.extensions.api;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ApiResponse {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NONE, SOME})
    public @interface Result {}

    public static final int NONE = 0;
    public static final int SOME = 1;

    private Object payload;
    private int responseResult;
    private boolean isSuccess;

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
