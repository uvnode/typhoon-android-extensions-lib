package com.uvnode.typhoon.extensions.model;

import java.util.ArrayList;

/**
 * Created by Riyadh on 7/2/2017.
 */

public class Listing {

    private String name;
    private ArrayList<Episode> episodes;

    public Listing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }
}
