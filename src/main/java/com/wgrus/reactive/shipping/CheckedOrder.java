package com.wgrus.reactive.shipping;

import com.wgrus.reactive.billing.CheckedCustomer;
import com.wgrus.reactive.inventory.check.CheckedInventoryOrder;

public class CheckedOrder {

    private CheckedCustomer checkedCustomer;
    private CheckedInventoryOrder checkedInventoryOrder;

    public CheckedOrder(CheckedCustomer checkedCustomer, CheckedInventoryOrder checkedInventoryOrder) {
        this.checkedCustomer = checkedCustomer;
        this.checkedInventoryOrder = checkedInventoryOrder;
    }

    public CheckedCustomer getCheckedCustomer() {
        return checkedCustomer;
    }

    public CheckedInventoryOrder getCheckedInventoryOrder() {
        return checkedInventoryOrder;
    }

    @Override
    public String toString() {
        return "CheckedOrder{" +
                "checkedCustomer=" + checkedCustomer +
                ", checkedInventoryOrder=" + checkedInventoryOrder +
                '}';
    }
}
