package com.uvnode.typhoon.sources;

import com.uvnode.typhoon.sources.api.ApiCallbacks;
import com.uvnode.typhoon.sources.model.Episode;
import com.uvnode.typhoon.sources.model.Genre;
import com.uvnode.typhoon.sources.model.Listing;
import com.uvnode.typhoon.sources.model.Ranking;
import com.uvnode.typhoon.sources.model.Series;
import com.uvnode.typhoon.sources.model.Source;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MetaSource {

    // Asynchronous

    public abstract void getRankings(ApiCallbacks apiConsumer);

    public abstract void getSeriesInRanking(ApiCallbacks apiConsumer, Ranking ranking);

    public abstract void getEpisodes(ApiCallbacks apiConsumer, Series series);

    public abstract void getVideoLinks(ApiCallbacks apiConsumer, String episodeLink);

    public abstract void search(ApiCallbacks apiConsumer, String query, int page);

    // Synchronous

    public abstract ArrayList<Ranking> getRankings();

    public abstract ArrayList<Series> getSeriesInRanking(Ranking ranking);

    public abstract ArrayList<Listing> getEpisodes(Series series);

    public abstract HashMap<String, Object> getVideoLinks(String episodeLink);

    public abstract HashMap<String, Object> search(String query, int page);

    public abstract Source getSource();
}
