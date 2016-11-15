package com.wgrus.reactive.input;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.catalog.gadget.GadgetCatalogItem;
import com.wgrus.reactive.catalog.widget.WidgetCatalogItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class Customer {

    private String customerId;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public List<CatalogItem> chooseCatalogItems() {
        List<CatalogItem> catalogItems = new ArrayList<>();
        List<CatalogItem> widgetCatalogItems = new Random()
                .ints(new Random().nextInt(10) + 1, 1, 10)
                .mapToObj(i -> new WidgetCatalogItem(valueOf(new Random().nextInt(10))))
                .collect(toList());
        List<CatalogItem> gadgetCatalogItems = new Random()
                .ints(new Random().nextInt(10) + 1, 1, 10)
                .mapToObj(i -> new GadgetCatalogItem(valueOf(new Random().nextInt(10))))
                .collect(toList());
        catalogItems.addAll(widgetCatalogItems);
        catalogItems.addAll(gadgetCatalogItems);
        return catalogItems;
    }

    public String getCustomerId() {
        return customerId;
    }
}
