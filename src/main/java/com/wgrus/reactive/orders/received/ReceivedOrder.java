package com.wgrus.reactive.orders.received;

import com.wgrus.reactive.catalog.CatalogItem;
import rx.Observable;

public class ReceivedOrder {

    private String orderId;
    private String customerId;
    private Observable<CatalogItem> orderedItems;

    public ReceivedOrder(String orderId, String customerId, Observable<CatalogItem> orderedItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderedItems = orderedItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Observable<CatalogItem> getOrderedItems() {
        return orderedItems;
    }

    @Override
    public String toString() {
        return "ReceivedOrder{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderedItems=" + orderedItems +
                '}';
    }
}
