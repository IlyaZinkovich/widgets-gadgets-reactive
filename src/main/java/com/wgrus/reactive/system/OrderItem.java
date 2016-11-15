package com.wgrus.reactive.system;

import com.wgrus.reactive.catalog.CatalogItem;
import com.wgrus.reactive.catalog.gadget.GadgetCatalogItem;
import com.wgrus.reactive.catalog.widget.WidgetCatalogItem;

public class OrderItem {

    private String modelNumber;
    private Type type;

    public static enum Type {
        WIDGET, GADGET;

        public static Type extractType(CatalogItem catalogItem) {
            Class c = catalogItem.getClass();
            if (WidgetCatalogItem.class.equals(c))
                return WIDGET;
            if (GadgetCatalogItem.class.equals(c))
                return GADGET;
            throw new RuntimeException("unsupported catalog item type");
        }
    }

    public OrderItem(String modelNumber, Type type) {
        this.modelNumber = modelNumber;
        this.type = type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "modelNumber='" + modelNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
