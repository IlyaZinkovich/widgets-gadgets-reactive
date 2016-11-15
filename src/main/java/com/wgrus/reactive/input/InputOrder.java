package com.wgrus.reactive.input;

import com.wgrus.reactive.catalog.CatalogItem;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public abstract class InputOrder {

    protected String customerId;
    protected List<CatalogItem> orderedItems;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<CatalogItem> getOrderedItems() {
        return unmodifiableList(orderedItems);
    }
}
