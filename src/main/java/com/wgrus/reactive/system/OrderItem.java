package com.wgrus.reactive.system;

public class OrderItem {

    private String modelNumber;
    private Type type;

    public enum Type {
        WIDGET, GADGET
    }

    public OrderItem(String modelNumber, Type type) {
        this.modelNumber = modelNumber;
        this.type = type;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "modelNumber='" + modelNumber + '\'' +
                ", type=" + type +
                '}';
    }
}
