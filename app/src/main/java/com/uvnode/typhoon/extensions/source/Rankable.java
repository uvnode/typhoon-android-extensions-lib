package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Ranking;

public interface Rankable {

    void getRankings(ApiCallbacks callbacks) throws Exception;

    void getSeriesList(ApiCallbacks callbacks, Ranking ranking) throws Exception;
}