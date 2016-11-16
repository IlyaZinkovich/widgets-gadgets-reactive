package com.wgrus.reactive.orders;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.CatalogItem;
import rx.Observable;

import java.util.Random;

public class Customer {

    private String customerId;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Observable<CatalogItem> chooseCatalogItems(Observable<Catalog> catalogs) {
        return catalogs
                .flatMap(Catalog::getItems)
                .filter(item -> new Random().nextBoolean());
    }

    public String getCustomerId() {
        return customerId;
    }
}
