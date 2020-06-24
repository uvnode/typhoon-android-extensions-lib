package com.uvnode.typhoon.extensions.api;

public interface ApiCallbacks  {
    void onFailure(ApiError e);
    void onSuccess(Object response);
}