package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Filter;

import java.util.ArrayList;

public interface Filterable {

    void getSeriesList(ApiCallbacks callbacks, ArrayList<Filter> filters);

    void search(ApiCallbacks callbacks, String query, int page);
}
