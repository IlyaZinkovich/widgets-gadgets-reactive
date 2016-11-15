package com.wgrus.reactive.system;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Order {

    private String orderId;
    private String customerId;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(String orderId, String customerId, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getOrderItems() {
        return unmodifiableList(orderItems);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
