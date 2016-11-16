package com.wgrus.reactive.orders;

import com.wgrus.reactive.catalog.CatalogItem;
import rx.Observable;

public abstract class InputOrder {

    protected String customerId;
    protected Observable<CatalogItem> orderedItems;

    public InputOrder(String customerId, Observable<CatalogItem> catalogItems) {
        this.customerId = customerId;
        this.orderedItems = catalogItems;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Observable<CatalogItem> getOrderedItems() {
        return orderedItems;
    }
}
