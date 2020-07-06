package com.uvnode.typhoon.extensions.source;

import com.uvnode.typhoon.extensions.api.ApiCallbacks;
import com.uvnode.typhoon.extensions.model.Episode;
import com.uvnode.typhoon.extensions.model.Mirror;
import com.uvnode.typhoon.extensions.model.Series;

public interface HasMirrors {

    void getVideoUris(ApiCallbacks callbacks, Series series, Episode episode, Mirror mirror);
}
