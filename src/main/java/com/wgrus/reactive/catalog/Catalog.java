package com.wgrus.reactive.catalog;

import rx.Observable;

public abstract class Catalog {

    protected Observable<CatalogItem> items;

    public Catalog(Observable<CatalogItem> items) {
        this.items = items;
    }

    public Observable<CatalogItem> getItems() {
        return items;
    }
}
