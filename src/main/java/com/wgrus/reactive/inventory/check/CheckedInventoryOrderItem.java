package com.wgrus.reactive.inventory.check;

import com.wgrus.reactive.orders.received.ReceivedOrderItem;

public class CheckedInventoryOrderItem extends ReceivedOrderItem {

    private Boolean available;

    public CheckedInventoryOrderItem(ReceivedOrderItem receivedOrderItem, boolean available) {
        super(receivedOrderItem.getOrderId(), receivedOrderItem.getType(), receivedOrderItem.getModelNumber());
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return getType() + " " + getModelNumber();
    }
}
