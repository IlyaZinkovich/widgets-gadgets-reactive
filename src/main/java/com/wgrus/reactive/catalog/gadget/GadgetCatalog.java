package com.wgrus.reactive.catalog.gadget;

import com.wgrus.reactive.catalog.Catalog;

import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import static rx.Observable.from;

public class GadgetCatalog extends Catalog {

    public GadgetCatalog() {
        super(from(IntStream.range(1, 10).mapToObj(i -> new GadgetCatalogItem(valueOf(i))).collect(toList())));
    }
}
