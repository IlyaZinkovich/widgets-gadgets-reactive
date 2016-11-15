package com.wgrus.reactive.catalog.gadget;

import com.wgrus.reactive.catalog.Catalog;

import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class GadgetCatalog extends Catalog {

    public GadgetCatalog() {
        this.items = IntStream.range(1, 10).mapToObj(i -> new GadgetCatalogItem(valueOf(i))).collect(toList());
    }
}
