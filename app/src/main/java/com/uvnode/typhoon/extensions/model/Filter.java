package com.uvnode.typhoon.extensions.model;

public class Filter<T> {

    public String name;
    public T state;

    public Filter(String name, T state) {
        this.name = name;
        this.state = state;
    }
}
