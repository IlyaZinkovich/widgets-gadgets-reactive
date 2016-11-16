package com.wgrus.reactive.orders.received;

import com.wgrus.reactive.catalog.CatalogItem.Type;

public class ReceivedOrderItem {

    private String orderId;
    private String customerId;
    private Type type;
    private String modelNumber;

    public ReceivedOrderItem(String orderId, String customerId, Type type, String modelNumber) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.type = type;
        this.modelNumber = modelNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
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
                ", customerId='" + customerId + '\'' +
                ", type=" + type +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
