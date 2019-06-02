package com.uvnode.typhoon.sources.api;

import java.io.IOException;

public interface ApiCallbacks  {
    void onFailure(IOException e);
    void onSuccess(Object response);
}