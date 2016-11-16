package com.wgrus.reactive;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.gadget.GadgetCatalog;
import com.wgrus.reactive.catalog.widget.WidgetCatalog;
import com.wgrus.reactive.input.callcenter.CallCenter;
import com.wgrus.reactive.input.web.Website;
import com.wgrus.reactive.inventory.check.AvailabilityChecker;
import com.wgrus.reactive.inventory.check.CheckInventoryItem;
import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;
import com.wgrus.reactive.system.Order;
import com.wgrus.reactive.system.OrderTransformer;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

import static com.wgrus.reactive.system.OrderItem.Type.GADGET;
import static com.wgrus.reactive.system.OrderItem.Type.WIDGET;
import static java.util.Arrays.asList;
import static rx.Observable.from;
import static rx.Observable.merge;

public class SystemPrototype {

    public static void main(String[] args) throws InterruptedException {

        List<Catalog> catalogs = asList(new WidgetCatalog(), new GadgetCatalog());

        Website website = new Website(catalogs);
        CallCenter callCenter = new CallCenter(catalogs);

        OrderTransformer orderTransformer = new OrderTransformer();

        WidgetInventory widgetInventory = new WidgetInventory();
        GadgetInventory gadgetInventory = new GadgetInventory();
        AvailabilityChecker availabilityChecker = new AvailabilityChecker();

        merge(website.getOrders().map(order -> orderTransformer.transform(order, WIDGET)),
                callCenter.getOrders().map(order -> orderTransformer.transform(order, GADGET)))
                .flatMap(order -> from(order.getOrderItems())
                .map(orderItem -> new CheckInventoryItem(order.getOrderId(), orderItem)))
                .groupBy(order -> order.getOrderItem().getType())
                .subscribe(groupedItems ->
                        availabilityChecker.getAvailableOrders(groupedItems, widgetInventory, gadgetInventory)
                                .subscribeOn(Schedulers.io())
                                .subscribe(System.out::println, System.out::println)
                );
    }
}