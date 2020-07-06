package com.uvnode.typhoon.extensions.model;

public class Video {

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
