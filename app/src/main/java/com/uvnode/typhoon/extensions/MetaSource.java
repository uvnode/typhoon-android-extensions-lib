package com.uvnode.typhoon.extensions;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Episode;
import com.uvnode.typhoon.extensions.model.Listing;
import com.uvnode.typhoon.extensions.model.Ranking;
import com.uvnode.typhoon.extensions.model.Series;
import com.uvnode.typhoon.extensions.model.Source;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MetaSource {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public abstract void getSeries(ApiCallbacks callbacks, Series series);

    public abstract void getSeriesList(ApiCallbacks callbacks);

    public abstract void getEpisodes(ApiCallbacks callbacks, Series series);

    public abstract void getVideoUrls(ApiCallbacks callbacks, Series series, Episode episode);

    public abstract void search(ApiCallbacks callbacks, String query, int page);

    public abstract Source getSource();
}
