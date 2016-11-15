package com.wgrus.reactive.catalog;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public abstract class Catalog {

    protected List<CatalogItem> items;

    public List<CatalogItem> getItems() {
        return unmodifiableList(items);
    }
}
