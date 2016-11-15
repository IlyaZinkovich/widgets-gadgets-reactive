package com.wgrus.reactive.input.callcenter;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.input.InputOrder;

import java.util.List;

public class CallCenterInputOrder extends InputOrder {

    public CallCenterInputOrder(String customerId, List<CatalogItem> catalogItems) {
        this.customerId = customerId;
        this.orderedItems = catalogItems;
    }

    @Override
    public String toString() {
        return "CallCenterInputOrder{" +
                "customerId='" + customerId + "\'" +
                '}';
    }
}
