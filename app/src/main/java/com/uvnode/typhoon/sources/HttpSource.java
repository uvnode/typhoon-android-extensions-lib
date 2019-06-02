package com.uvnode.typhoon.sources;

import com.uvnode.typhoon.sources.model.Genre;
import com.uvnode.typhoon.sources.model.Listing;
import com.uvnode.typhoon.sources.model.Ranking;
import com.uvnode.typhoon.sources.model.Series;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public abstract class HttpSource {

    private OkHttpClient okClient;

    public abstract ArrayList<Ranking> getRankings();

    public abstract ArrayList<Genre> getGenres();

    public abstract ArrayList<Series> getSeriesInRanking(Ranking ranking);

    public abstract ArrayList<Series> getSeriesInGenre(Genre genre);

    public abstract ArrayList<Listing> getEpisodes(Series series);

    public abstract ArrayList<Series> search(String query);

    public void setOkClient(OkHttpClient okClient) {
        this.okClient = okClient;
    }
}
