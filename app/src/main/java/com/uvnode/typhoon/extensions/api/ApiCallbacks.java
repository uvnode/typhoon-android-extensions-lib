package com.uvnode.typhoon.extensions.api;

import java.io.IOException;

public interface ApiCallbacks  {
    void onFailure(IOException e);
    void onSuccess(Object response);
}