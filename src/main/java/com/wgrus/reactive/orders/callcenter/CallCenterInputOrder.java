package com.wgrus.reactive.orders.callcenter;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.orders.InputOrder;
import rx.Observable;

public class CallCenterInputOrder extends InputOrder {

    public CallCenterInputOrder(String customerId, Observable<CatalogItem> catalogItems) {
        super(customerId, catalogItems);
    }

    @Override
    public String toString() {
        return "CallCenterInputOrder{" +
                "customerId='" + customerId + "\'" +
                '}';
    }
}
