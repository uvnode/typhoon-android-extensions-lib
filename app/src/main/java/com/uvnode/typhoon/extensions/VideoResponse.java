package com.uvnode.typhoon.extensions;

import java.util.ArrayList;

public class VideoResponse {

    private ArrayList uris;
    private int type, format;
    private boolean success;

    public VideoResponse(ArrayList uris, int type, int format, boolean success) {
        this.uris = uris;
        this.type = type;
        this.format = format;
        this.success = success;
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
