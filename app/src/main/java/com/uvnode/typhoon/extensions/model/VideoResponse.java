package com.uvnode.typhoon.extensions.model;

import java.util.ArrayList;

public class VideoResponse {

    public static final int ERROR_UNKNOWN = 0;
    public static final int ERROR_TIMEOUT = 1;
    public static final int ERROR_SOURCE_NOT_FOUND = 2;
    public static final int ERROR_LINKS_NOT_FOUND = 3;

    private ArrayList<Video> uris;
    private int errorCode;
    private boolean success;

    private String backupUri;

    public VideoResponse(ArrayList<Video> uris, boolean success) {
        this.uris = uris;
        this.success = success;
        this.backupUri = "";
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public ArrayList<Video> getUris() {
        return uris;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getBackupUri() {
        return backupUri;
    }

    public void setBackupUri(String backupUri) {
        this.backupUri = backupUri;
    }
}
