package com.wgrus.reactive.inventory.widget;

import com.wgrus.reactive.inventory.InventoryItem;

public class Widget extends InventoryItem {

    public Widget(String modelNumber) {
        super(modelNumber);
    }

    @Override
    public String toString() {
        return "Widget{" +
                "modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
