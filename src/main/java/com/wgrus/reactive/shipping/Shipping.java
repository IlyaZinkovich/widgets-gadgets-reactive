package com.wgrus.reactive.shipping;

import com.wgrus.reactive.inventory.check.CheckedInventoryOrderItem;

public class Shipping {

    public void ship(CheckedOrder checkedOrder) {
        System.out.println("################################");
        System.out.println("Customer: " + checkedOrder.getCheckedCustomer().getCustomerId());
        System.out.println("OrderId: " + checkedOrder.getCheckedInventoryOrder().getOrderId());
        System.out.println("Order Items: ");
        checkedOrder.getCheckedInventoryOrder().getOrderItems().filter(CheckedInventoryOrderItem::getAvailable)
                .forEach(System.out::println);
    }
}
