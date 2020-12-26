package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Listing;
import com.uvnode.typhoon.extensions.model.Series;

public interface HasListings {

    void getListings(ApiCallbacks apiConsumer, Series series) throws Exception;

    void getEpisodesList(ApiCallbacks apiConsumer, Series series, Listing listing) throws Exception;
}
