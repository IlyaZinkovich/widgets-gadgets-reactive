package com.wgrus.reactive.orders.web;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.orders.InputOrder;
import rx.Observable;

public class WebsiteInputOrder extends InputOrder {

    public WebsiteInputOrder(String customerId, Observable<CatalogItem> catalogItems) {
        super(customerId, catalogItems);
    }

    @Override
    public String toString() {
        return "WebsiteInputOrder{" +
                "customerId='" + customerId + "\'" +
                '}';
    }
}
