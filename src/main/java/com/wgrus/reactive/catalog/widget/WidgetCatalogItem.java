package com.wgrus.reactive.catalog.widget;

import com.wgrus.reactive.catalog.CatalogItem;

import static com.wgrus.reactive.catalog.CatalogItem.Type.WIDGET;

public class WidgetCatalogItem extends CatalogItem {

    public WidgetCatalogItem(String modelNumber) {
        super(modelNumber, WIDGET);
    }
}
