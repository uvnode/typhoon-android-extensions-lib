package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Episode;
import com.uvnode.typhoon.extensions.model.Listing;
import com.uvnode.typhoon.extensions.model.Ranking;
import com.uvnode.typhoon.extensions.model.Series;
import com.uvnode.typhoon.extensions.model.Source;

import java.util.HashMap;

public abstract class MetaSource {

    private boolean enabled;

    public final boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public abstract void getSeries(ApiCallbacks callbacks, Series series) throws Exception;

    public abstract void getSeriesList(ApiCallbacks callbacks) throws Exception;

    public abstract void getEpisode(ApiCallbacks callbacks, Episode episode) throws Exception;

    public abstract void getEpisodesList(ApiCallbacks callbacks, Series series) throws Exception;

    public abstract void getVideoUris(ApiCallbacks callbacks, Series series, Episode episode) throws Exception;

    public abstract Source getSource();
}
