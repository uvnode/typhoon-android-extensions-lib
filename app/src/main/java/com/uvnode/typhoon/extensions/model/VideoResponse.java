package com.uvnode.typhoon.extensions.model;

import java.util.ArrayList;

public class VideoResponse {

    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_TIMEOUT = 1;
    public static final int ERROR_SOURCE_NOT_FOUND = 2;
    public static final int ERROR_LINKS_NOT_FOUND = 3;

    public static final int FORMAT_MP4 = 1;
    public static final int FORMAT_DASH = 2;
    public static final int FORMAT_HLS = 3;

    private ArrayList uris;
    private int type, format, errorCode;
    private boolean success;

    public VideoResponse(ArrayList uris, int type, int format, boolean success) {
        this.uris = uris;
        this.type = type;
        this.format = format;
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

    public int getType() {
        return type;
    }

    public int getFormat() {
        return format;
    }

    public boolean isSuccess() {
        return success;
    }
}
