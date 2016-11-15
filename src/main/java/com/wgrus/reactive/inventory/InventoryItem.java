package com.wgrus.reactive.inventory;

public abstract class InventoryItem {

    protected String modelNumber;

    public InventoryItem(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
}
