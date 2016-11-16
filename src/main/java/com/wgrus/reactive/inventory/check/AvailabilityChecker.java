package com.wgrus.reactive.inventory.check;

import com.wgrus.reactive.inventory.gadget.GadgetInventory;
import com.wgrus.reactive.inventory.widget.WidgetInventory;
import com.wgrus.reactive.system.OrderItem.Type;
import rx.Observable;
import rx.Subscriber;
import rx.observables.GroupedObservable;

import static com.wgrus.reactive.system.OrderItem.Type.GADGET;
import static com.wgrus.reactive.system.OrderItem.Type.WIDGET;

public class AvailabilityChecker {

    public Observable<CheckInventoryItem> getAvailableOrders(GroupedObservable<Type, CheckInventoryItem> groupedItems,
                                                             WidgetInventory widgetInventory,
                                                             GadgetInventory gadgetInventory) {
        return Observable.create(subscriber ->
                getAvailableOrderItems(subscriber, groupedItems, widgetInventory, gadgetInventory));
    }

    private void getAvailableOrderItems(Subscriber<? super CheckInventoryItem> subscriber,
                                        GroupedObservable<Type, CheckInventoryItem> groupedItems,
                                        WidgetInventory widgetInventory, GadgetInventory gadgetInventory) {
        if (WIDGET.equals(groupedItems.getKey())) {
            groupedItems.filter(order -> widgetInventory.isAvailable(order.getOrderItem().getModelNumber()))
                    .subscribe(subscriber::onNext);
        }
        if (GADGET.equals(groupedItems.getKey())) {
            groupedItems.filter(order -> gadgetInventory.isAvailable(order.getOrderItem().getModelNumber()))
                    .subscribe(subscriber::onNext);
        }
        subscriber.onCompleted();
    }
}
