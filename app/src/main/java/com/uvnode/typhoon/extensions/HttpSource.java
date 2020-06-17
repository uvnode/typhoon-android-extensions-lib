package com.uvnode.typhoon.extensions;

import com.uvnode.typhoon.extensions.executor.JSEClient;

import okhttp3.OkHttpClient;

public abstract class HttpSource extends MetaSource{

    private OkHttpClient okClient;
    private JSEClient jseClient;

    public OkHttpClient getOkClient() {
        return okClient;
    }

    public void setOkClient(OkHttpClient okClient) {
        this.okClient = okClient;
    }

    public void setJSEClient(JSEClient jseClient) { this.jseClient = jseClient; }
}
