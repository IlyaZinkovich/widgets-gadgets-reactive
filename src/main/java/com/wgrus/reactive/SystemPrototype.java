package com.wgrus.reactive;

import com.wgrus.reactive.input.InputOrder;
import com.wgrus.reactive.input.callcenter.CallCenter;
import com.wgrus.reactive.input.callcenter.CallCenterInputOrder;
import com.wgrus.reactive.input.web.WebsiteInputOrder;
import com.wgrus.reactive.input.web.Website;
import com.wgrus.reactive.system.Order;
import com.wgrus.reactive.system.OrderItem;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

import static com.wgrus.reactive.system.OrderItem.Type.extractType;
import static java.util.stream.Collectors.toList;

public class SystemPrototype {

    private static Long orderIdCounter = 1L;

    public static void main(String[] args) throws InterruptedException {
        Website website = new Website();
        CallCenter callCenter = new CallCenter();

        Observable<WebsiteInputOrder> websiteOrders = website.getOrders();
        Observable<CallCenterInputOrder> callCenterOrders = callCenter.getOrders();

        Observable<InputOrder> ordersFromWebsiteQueue = websiteOrders.map(SystemPrototype::processOrder);
        Observable<InputOrder> ordersFromCallCenterQueue = callCenterOrders.map(SystemPrototype::processOrder);

        ordersFromWebsiteQueue.mergeWith(ordersFromCallCenterQueue)
                .subscribeOn(Schedulers.newThread())
                .map(SystemPrototype::transformInputOrder)
                .subscribe(System.out::println, System.out::println);

        while (true) {

        }
    }

    private static InputOrder processOrder(InputOrder inputOrder) {
        return inputOrder;
    }

    private static Order transformInputOrder(InputOrder inputOrder) {
        return new Order(String.valueOf(orderIdCounter++), inputOrder.getCustomerId(),
                transformInputOrderItemsToOrderItems(inputOrder));
    }

    private static List<OrderItem> transformInputOrderItemsToOrderItems(InputOrder inputOrder) {
        return inputOrder.getOrderedItems().stream()
                .map(inputOrderItem -> new OrderItem(inputOrderItem.getModelNumber(), extractType(inputOrderItem)))
                .collect(toList());
    }
}