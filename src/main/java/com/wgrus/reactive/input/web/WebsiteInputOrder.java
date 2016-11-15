package com.wgrus.reactive.input.web;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.input.InputOrder;

import java.util.List;

public class WebsiteInputOrder extends InputOrder {

    public WebsiteInputOrder(String customerId, List<CatalogItem> catalogItems) {
        this.customerId = customerId;
        this.orderedItems = catalogItems;
    }

    @Override
    public String toString() {
        return "WebsiteInputOrder{" +
                "customerId='" + customerId + "\'" +
                '}';
    }
}
