package com.uvnode.typhoon.sources;

import okhttp3.OkHttpClient;

public abstract class HttpSource extends MetaSource{

    private OkHttpClient okClient;

    public OkHttpClient getOkClient() {
        return okClient;
    }

    public void setOkClient(OkHttpClient okClient) {
        this.okClient = okClient;
    }
}
