package com.wgrus.reactive.input.callcenter;

import com.wgrus.reactive.input.Customer;
import rx.Observable;
import rx.Subscriber;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class CallCenter {

    public Observable<CallCenterInputOrder> getOrders() {
        return Observable.create(subscriber -> publishOrder(subscriber));
    }

    private void publishOrder(Subscriber<? super CallCenterInputOrder> subscriber) {
        IntStream.range(1, 10001)
                .mapToObj(i -> new Customer(generateCustomerId()))
                .map(customer -> new CallCenterInputOrder(customer.getCustomerId(), customer.chooseCatalogItems()))
                .forEach(subscriber::onNext);
    }

    private String generateCustomerId() {
        return valueOf(new Random().nextInt(100));
    }
}
