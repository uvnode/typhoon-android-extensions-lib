package com.uvnode.typhoon.extensions.model;

public class Video {

    public static final int FORMAT_MP4 = 1;
    public static final int FORMAT_DASH = 2;
    public static final int FORMAT_HLS = 3;

    private String uri, name;
    private int format;

    public Video(String uri, String name, int format) {
        this.uri = uri;
        this.name = name;
        this.format = format;
    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public int getFormat() {
        return format;
    }
}
