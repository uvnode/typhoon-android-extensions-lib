package com.uvnode.typhoon.extensions;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.executor.JSEClient;
import com.uvnode.typhoon.extensions.model.Listing;
import com.uvnode.typhoon.extensions.model.Series;

import okhttp3.OkHttpClient;

public abstract class HttpSource extends MetaSource implements Rankable, Filterable {

    private OkHttpClient okClient;
    private JSEClient jseClient;

    public OkHttpClient getOkClient() {
        return okClient;
    }

    public JSEClient getJseClient() { return jseClient; };

    public void setOkClient(OkHttpClient okClient) {
        this.okClient = okClient;
    }

    public void setJSEClient(JSEClient jseClient) { this.jseClient = jseClient; }

    public abstract void getListings(ApiCallbacks apiConsumer, Series series);

    public abstract void getEpisodesList(ApiCallbacks apiConsumer, Series series, Listing listing);
}
