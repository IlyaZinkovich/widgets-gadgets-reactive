package com.wgrus.reactive.orders.received;

import com.wgrus.reactive.catalog.CatalogItem.Type;

public class ReceivedOrderItem {

    private String orderId;
    private Type type;
    private String modelNumber;

    public ReceivedOrderItem(String orderId, Type type, String modelNumber) {
        this.orderId = orderId;
        this.type = type;
        this.modelNumber = modelNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public Type getType() {
        return type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    @Override
    public String toString() {
        return "ReceivedOrderItem{" +
                "orderId='" + orderId + '\'' +
                ", type=" + type +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
