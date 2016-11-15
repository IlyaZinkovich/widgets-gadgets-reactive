package com.wgrus.reactive.catalog;

import java.util.List;

public abstract class Catalog {

    protected List<CatalogItem> items;

    public List<CatalogItem> getItems() {
        return items;
    }

    public void setItems(List<CatalogItem> items) {
        this.items = items;
    }
}
