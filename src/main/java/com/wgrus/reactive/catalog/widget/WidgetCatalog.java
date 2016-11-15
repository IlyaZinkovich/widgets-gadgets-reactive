package com.wgrus.reactive.catalog.widget;

import com.wgrus.reactive.catalog.Catalog;

import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class WidgetCatalog extends Catalog {

    public WidgetCatalog() {
        this.items = IntStream.range(1, 10).mapToObj(i -> new WidgetCatalogItem(valueOf(i))).collect(toList());
    }
}
