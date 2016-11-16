package com.wgrus.reactive.orders.callcenter;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.orders.Customer;
import rx.Observable;
import rx.Subscriber;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class CallCenter {

    private Observable<Catalog> catalogs;

    public CallCenter(Observable<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public Observable<CallCenterInputOrder> getOrders() {
        return Observable.create(subscriber -> publishOrder(subscriber));
    }

    private void publishOrder(Subscriber<? super CallCenterInputOrder> subscriber) {
        IntStream.range(1, 21)
                .mapToObj(i -> new Customer(generateCustomerId()))
                .map(customer ->
                        new CallCenterInputOrder(customer.getCustomerId(), customer.chooseCatalogItems(catalogs)))
                .forEach(subscriber::onNext);
        subscriber.onCompleted();
    }

    private String generateCustomerId() {
        return valueOf(new Random().nextInt(100));
    }
}
