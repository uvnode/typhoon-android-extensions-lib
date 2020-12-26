package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Filter;

import java.util.List;

public interface Filterable {

    List<Filter> getFilters();

    void search(ApiCallbacks callbacks, List<Filter> filters, int page) throws Exception;
}
