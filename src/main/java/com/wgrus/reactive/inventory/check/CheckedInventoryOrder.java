package com.wgrus.reactive.inventory.check;

import rx.Observable;

public class CheckedInventoryOrder {

    private String orderId;
    private Observable<CheckedInventoryOrderItem> orderItems;

    public CheckedInventoryOrder(String orderId, Observable<CheckedInventoryOrderItem> orderItems) {
        this.orderId = orderId;
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public Observable<CheckedInventoryOrderItem> getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "CheckedInventoryOrder{" +
                "orderId=" + orderId +
                ", orderItems=" + orderItems +
                '}';
    }
}
