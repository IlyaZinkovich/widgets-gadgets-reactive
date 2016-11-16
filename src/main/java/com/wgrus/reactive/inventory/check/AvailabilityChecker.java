package com.wgrus.reactive.inventory.check;

import com.wgrus.reactive.orders.received.ReceivedOrderItem;
import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;

public class AvailabilityChecker {

    public CheckedInventoryOrderItem getCheckItemAvailability(WidgetInventory widgetInventory, GadgetInventory gadgetInventory, ReceivedOrderItem receivedOrderItem) {
        if (CatalogItem.Type.WIDGET.equals(receivedOrderItem.getType())) {
            return new CheckedInventoryOrderItem(receivedOrderItem, widgetInventory.isAvailable(receivedOrderItem.getModelNumber()));
        }
        if (CatalogItem.Type.GADGET.equals(receivedOrderItem.getType())) {
            return new CheckedInventoryOrderItem(receivedOrderItem, gadgetInventory.isAvailable(receivedOrderItem.getModelNumber()));
        }
        throw new RuntimeException("Unsupported item type");
    }
}
