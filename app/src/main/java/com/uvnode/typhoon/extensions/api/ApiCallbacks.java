package com.uvnode.typhoon.extensions.api;

public interface ApiCallbacks  {
    void onFailure(ApiError error);
    void onResponse(ApiResponse response);
}