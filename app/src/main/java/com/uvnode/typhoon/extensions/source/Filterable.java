package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Filter;

import java.util.ArrayList;

public interface Filterable {

    ArrayList<Filter> getFilters();

    void search(ApiCallbacks callbacks, ArrayList<Filter> filters, int page) throws Exception;
}
