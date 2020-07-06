package com.uvnode.typhoon.extensions.model;

import java.util.ArrayList;

public class PaginatedList {

    private ArrayList list;
    private boolean hasNext;

    public PaginatedList(ArrayList list, boolean hasNext) {
        this.list = list;
        this.hasNext = hasNext;
    }

    public ArrayList getList() {
        return list;
    }

    public boolean isHasNext() {
        return hasNext;
    }
}
