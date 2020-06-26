package com.uvnode.typhoon.extensions;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Ranking;

public interface Rankable {

    public void getRankings(ApiCallbacks callbacks);

    public void getSeriesInRanking(ApiCallbacks callbacks, Ranking ranking);
}
