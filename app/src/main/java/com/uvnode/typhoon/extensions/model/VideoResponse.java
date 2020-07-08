package com.uvnode.typhoon.extensions.model;

import java.util.ArrayList;

public class VideoResponse {

    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_TIMEOUT = 1;
    public static final int ERROR_SOURCE_NOT_FOUND = 2;
    public static final int ERROR_LINKS_NOT_FOUND = 3;

    private ArrayList uris;
    private int errorCode;
    private boolean success;

    public VideoResponse(ArrayList uris, boolean success) {
        this.uris = uris;
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ArrayList getUris() {
        return uris;
    }

    public boolean isSuccess() {
        return success;
    }
}
