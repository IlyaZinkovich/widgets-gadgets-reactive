package com.wgrus.reactive.input;

import com.wgrus.reactive.catalog.Catalog;
import com.wgrus.reactive.catalog.CatalogItem;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class Customer {

    private String customerId;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public List<CatalogItem> chooseCatalogItems(List<Catalog> catalogs) {
        return catalogs.stream()
                .flatMap(catalog -> catalog.getItems().stream())
                .filter(item -> new Random().nextBoolean())
                .collect(toList());
    }

    public String getCustomerId() {
        return customerId;
    }
}
