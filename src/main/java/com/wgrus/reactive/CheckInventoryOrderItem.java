package com.wgrus.reactive;

import com.wgrus.reactive.system.OrderItem;

public class CheckInventoryOrderItem {

    private String orderId;
    private OrderItem orderItem;

    public CheckInventoryOrderItem(String orderId, OrderItem orderItem) {
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
        return "CheckInventoryOrderItem{" +
                "orderId='" + orderId + '\'' +
                ", orderItem=" + orderItem +
                '}';
    }
}
