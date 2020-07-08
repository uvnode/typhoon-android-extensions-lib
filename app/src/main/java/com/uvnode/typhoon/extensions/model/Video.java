package com.uvnode.typhoon.extensions.model;

public class Video {

    public static final int FORMAT_MP4 = 1;
    public static final int FORMAT_DASH = 2;
    public static final int FORMAT_HLS = 3;

    private String uri, name;

    public Video(String uri, String name) {
        setUri(uri);
        setName(name);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
