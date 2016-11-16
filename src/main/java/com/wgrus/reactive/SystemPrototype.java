package com.wgrus.reactive;

import com.wgrus.reactive.billing.Billing;
import com.wgrus.reactive.billing.CheckedCustomer;
import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.gadget.GadgetCatalog;
import com.wgrus.reactive.catalog.widget.WidgetCatalog;
import com.wgrus.reactive.inventory.check.AvailabilityChecker;
import com.wgrus.reactive.inventory.check.CheckedInventoryOrder;
import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;
import com.wgrus.reactive.orders.callcenter.CallCenter;
import com.wgrus.reactive.orders.received.ReceivedOrder;
import com.wgrus.reactive.orders.received.ReceivedOrderItem;
import com.wgrus.reactive.orders.received.Receiver;
import com.wgrus.reactive.orders.web.Website;
import com.wgrus.reactive.shipping.CheckedOrder;
import com.wgrus.reactive.shipping.Shipping;
import rx.Observable;

import java.util.List;

import static java.util.Arrays.asList;
import static rx.Observable.from;
import static rx.Observable.merge;
import static rx.Observable.zip;

public class SystemPrototype {

    public static void main(String[] args) throws InterruptedException {
        List<Catalog> catalogs = asList(new WidgetCatalog(), new GadgetCatalog());

        Website website = new Website(from(catalogs));
        CallCenter callCenter = new CallCenter(from(catalogs));
        Receiver receiver = new Receiver();

        Observable<ReceivedOrder> receivedOrders =
                merge(website.getOrders()
                                .map(order -> receiver.receiveOrder(order.getCustomerId(), order.getOrderedItems())),
                        callCenter.getOrders()
                                .map(order -> receiver.receiveOrder(order.getCustomerId(), order.getOrderedItems())))
                        .share();

        WidgetInventory widgetInventory = new WidgetInventory();
        GadgetInventory gadgetInventory = new GadgetInventory();
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();

        Observable<CheckedInventoryOrder> checkedInventoryOrders =
                receivedOrders
                .flatMap(receivedOrder -> receivedOrder.getOrderedItems()
                        .map(catalogItem ->
                                new ReceivedOrderItem(receivedOrder.getOrderId(),
                                        catalogItem.getType(), catalogItem.getModelNumber())))
                        .map(receivedOrderItem ->
                                availabilityChecker.getCheckItemAvailability(widgetInventory, gadgetInventory,
                                        receivedOrderItem))
                        .groupBy(ReceivedOrderItem::getOrderId)
                        .map(orderGroup -> new CheckedInventoryOrder(orderGroup.getKey(), orderGroup.asObservable()));

        Billing billing = new Billing();

        Observable<CheckedCustomer> checkedCustomers =
                receivedOrders.map(order ->
                        new CheckedCustomer(order.getCustomerId(), billing.checkCustomerForOrder(order)));

        Shipping shipping = new Shipping();

        zip(checkedCustomers, checkedInventoryOrders, CheckedOrder::new)
                .filter(checkedOrder -> checkedOrder.getCheckedCustomer().getAccepted())
                .forEach(shipping::ship);
    }
}