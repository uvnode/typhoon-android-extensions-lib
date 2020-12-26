package com.uvnode.typhoon.extensions.model;

import java.util.List;

public class PaginatedList {

    private List list;
    private boolean hasNext;

    public PaginatedList(List list, boolean hasNext) {
        this.list = list;
        this.hasNext = hasNext;
    }

    public List getList() {
        return list;
    }

    public boolean isHasNext() {
        return hasNext;
    }
}
