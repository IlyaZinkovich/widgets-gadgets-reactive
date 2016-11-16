package com.wgrus.reactive.inventory.check;

import com.wgrus.reactive.system.OrderItem;

public class CheckInventoryItem {

    private String orderId;
    private OrderItem orderItem;

    public CheckInventoryItem(String orderId, OrderItem orderItem) {
        this.orderId = orderId;
        this.orderItem = orderItem;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    @Override
    public String toString() {
        return "CheckInventoryItem{" +
                "orderId='" + orderId + '\'' +
                ", orderItem=" + orderItem +
                '}';
    }
}
