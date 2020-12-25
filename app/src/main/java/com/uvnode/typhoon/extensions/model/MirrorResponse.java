package com.uvnode.typhoon.extensions.model;

import java.util.List;

public class MirrorResponse implements WatchableResponse {

    private List<Mirror> mirrors;

    public MirrorResponse(List<Mirror> mirrors) {
        this.mirrors = mirrors;
    }

    public List<Mirror> getMirrors() {
        return mirrors;
    }

}
