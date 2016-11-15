package com.wgrus.reactive.catalog;

public abstract class CatalogItem {

    protected String modelNumber;

    public CatalogItem(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }
}
