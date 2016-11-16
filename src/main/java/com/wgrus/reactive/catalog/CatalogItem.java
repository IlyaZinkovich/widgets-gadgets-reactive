package com.wgrus.reactive.catalog;

public abstract class CatalogItem {

    protected String modelNumber;
    protected Type type;

    public enum Type {
        WIDGET, GADGET
    }

    public CatalogItem(String modelNumber, Type type) {
        this.modelNumber = modelNumber;
        this.type = type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public Type getType() {
        return type;
    }
}
