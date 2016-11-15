package com.wgrus.reactive.input.web;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.input.Customer;
import rx.Observable;
import rx.Subscriber;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;

public class Website {

    private List<Catalog> catalogs;

    public Website(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public Observable<WebsiteInputOrder> getOrders() {
        return Observable.create(subscriber -> publishOrder(subscriber));
    }

    private void publishOrder(Subscriber<? super WebsiteInputOrder> subscriber) {
        IntStream.range(1, 10001)
                .mapToObj(i -> new Customer(generateCustomerId()))
                .map(customer ->
                        new WebsiteInputOrder(customer.getCustomerId(), customer.chooseCatalogItems(catalogs)))
                .forEach(subscriber::onNext);
    }

    private String generateCustomerId() {
        return valueOf(new Random().nextInt(100));
    }
}
