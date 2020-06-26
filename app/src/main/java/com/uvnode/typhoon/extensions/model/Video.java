package com.uvnode.typhoon.extensions.model;

public class Video {

    private String url, name;

    public Video(String url, String name) {
        setUrl(url);
        setName(name);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
