package com.wgrus.reactive.inventory.gadget;

import com.wgrus.reactive.inventory.InventoryItem;

public class Gadget extends InventoryItem {

    public Gadget(String modelNumber) {
        super(modelNumber);
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
