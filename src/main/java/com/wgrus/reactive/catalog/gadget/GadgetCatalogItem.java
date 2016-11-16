package com.wgrus.reactive.catalog.gadget;

import com.wgrus.reactive.catalog.CatalogItem;

import static com.wgrus.reactive.catalog.CatalogItem.Type.GADGET;

public class GadgetCatalogItem extends CatalogItem {

    public GadgetCatalogItem(String modelNumber) {
        super(modelNumber, GADGET);
    }
}
