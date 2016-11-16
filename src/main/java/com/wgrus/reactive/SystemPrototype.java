package com.wgrus.reactive;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.gadget.GadgetCatalog;
import com.wgrus.reactive.catalog.widget.WidgetCatalog;
import com.wgrus.reactive.inventory.check.AvailabilityChecker;
import com.wgrus.reactive.inventory.check.CheckedInventoryOrder;
import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;
import com.wgrus.reactive.orders.callcenter.CallCenter;
import com.wgrus.reactive.orders.received.ReceivedOrderItem;
import com.wgrus.reactive.orders.received.Receiver;
import com.wgrus.reactive.orders.web.Website;

import java.util.List;

import static java.util.Arrays.asList;
import static rx.Observable.from;
import static rx.Observable.merge;

public class SystemPrototype {

    public static void main(String[] args) throws InterruptedException {

        List<Catalog> catalogs = asList(new WidgetCatalog(), new GadgetCatalog());

        Website website = new Website(from(catalogs));
        CallCenter callCenter = new CallCenter(from(catalogs));
        Receiver receiver = new Receiver();

        WidgetInventory widgetInventory = new WidgetInventory();
        GadgetInventory gadgetInventory = new GadgetInventory();
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();

        merge(website.getOrders().map(order -> receiver.receiveOrder(order.getCustomerId(), order.getOrderedItems())),
                callCenter.getOrders().map(order -> receiver.receiveOrder(order.getCustomerId(), order.getOrderedItems())))
                .flatMap(receivedOrder -> receivedOrder.getOrderedItems().map(catalogItem ->
                        new ReceivedOrderItem(receivedOrder.getOrderId(), receivedOrder.getCustomerId(),
                                catalogItem.getType(), catalogItem.getModelNumber())))
                .map(receivedOrderItem -> availabilityChecker.getCheckItemAvailability(widgetInventory, gadgetInventory, receivedOrderItem))
                .groupBy(ReceivedOrderItem::getOrderId)
                .map(orderGroup -> new CheckedInventoryOrder(orderGroup.getKey(), orderGroup.asObservable()))
                .forEach(order -> {
                    System.out.println("OrderId: " + order.getOrderId());
                    order.getOrderItems().forEach(System.out::println);
                });
    }
}