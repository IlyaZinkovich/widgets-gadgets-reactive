package com.wgrus.reactive.orders.received;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.orders.InputOrder;
import rx.Observable;

public class ReceivedOrder extends InputOrder {

    private String orderId;

    public ReceivedOrder(String orderId, String customerId, Observable<CatalogItem> catalogItems) {
        super(customerId, catalogItems);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
