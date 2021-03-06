package com.wgrus.reactive.orders.received;

import com.wgrus.reactive.catalog.CatalogItem;
import rx.Observable;

import static java.lang.String.valueOf;

public class Receiver {

    private static Long orderCounter = 0L;

    public ReceivedOrder receiveOrder(String customerId, Observable<CatalogItem> orderedItems) {
        return new ReceivedOrder(valueOf(++orderCounter), customerId, orderedItems);
    }
}
