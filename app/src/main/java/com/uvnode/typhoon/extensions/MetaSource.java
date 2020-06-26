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

    public abstract void getRankings(ApiCallbacks apiConsumer);

    public abstract void getSeriesInRanking(ApiCallbacks apiConsumer, Ranking ranking);

    public abstract void getSeries(ApiCallbacks apiConsumer, Series series);

    public abstract void getEpisodes(ApiCallbacks apiConsumer, Series series);

    public abstract void getVideoUrls(ApiCallbacks apiConsumer, Series series, Episode episode);

    public abstract void search(ApiCallbacks apiConsumer, String query, int page);

    public abstract Source getSource();
}
