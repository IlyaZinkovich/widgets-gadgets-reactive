package com.wgrus.reactive;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.gadget.GadgetCatalog;
import com.wgrus.reactive.catalog.widget.WidgetCatalog;
import com.wgrus.reactive.input.callcenter.CallCenter;
import com.wgrus.reactive.input.web.Website;
import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;
import com.wgrus.reactive.system.Order;
import com.wgrus.reactive.system.OrderItem;
import com.wgrus.reactive.system.OrderTransformer;
import rx.Observable;
import rx.Subscriber;
import rx.observables.GroupedObservable;

import java.util.ArrayList;
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

        Observable<Order> orders = merge(website.getOrders().map(order -> orderTransformer.transform(order, WIDGET)),
                callCenter.getOrders().map(order -> orderTransformer.transform(order, GADGET)));

//        Observable<OrderItem> orderItems = orders.map(Order::getOrderItems).flatMap(Observable::from);

        WidgetInventory widgetInventory = new WidgetInventory();
        GadgetInventory gadgetInventory = new GadgetInventory();

        Observable<CheckInventoryOrderItem> checkInventoryOrderItems = orders.flatMap(order -> from(order.getOrderItems())
                .map(orderItem -> new CheckInventoryOrderItem(order.getOrderId(), orderItem)));

        List<CheckInventoryOrderItem> items = new ArrayList<>();

        checkInventoryOrderItems.groupBy(order -> order.getOrderItem().getType()).subscribe(new Subscriber<GroupedObservable<OrderItem.Type, CheckInventoryOrderItem>>() {
            @Override
            public void onCompleted() {
//                from(items).groupBy(CheckInventoryOrderItem::getOrderId).subscribe();
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(GroupedObservable<OrderItem.Type, CheckInventoryOrderItem> observable) {
                checkItemsAvailability(observable, widgetInventory, items, gadgetInventory);
            }
        });
//        orderItems.filter(orderItem -> orderItem.getType().equals(GADGET))
//                .filter(gadget -> gadgetInventory.isAvailable(gadget.getModelNumber()));
//                subscribeOn(Schedulers.io())
//        orders
//                .subscribeOn(Schedulers.io())
//                .subscribe(System.out::println, System.out::println);

        while (true) {

        }
    }

    private static void checkItemsAvailability(GroupedObservable<OrderItem.Type, CheckInventoryOrderItem> observable,
                                               WidgetInventory widgetInventory, List<CheckInventoryOrderItem> items,
                                               GadgetInventory gadgetInventory) {
        if (WIDGET.equals(observable.getKey())) {
            observable.filter(order -> widgetInventory.isAvailable(order.getOrderItem().getModelNumber()))
                .subscribe(items::add);
        }
        if (GADGET.equals(observable.getKey())) {
            observable.filter(order -> gadgetInventory.isAvailable(order.getOrderItem().getModelNumber()))
                    .subscribe(items::add);
        }
    }
}