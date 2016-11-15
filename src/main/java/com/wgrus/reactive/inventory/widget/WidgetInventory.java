package com.wgrus.reactive.inventory.widget;

import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class WidgetInventory {

    private List<Widget> availableWidgets;

    public WidgetInventory() {
        this.availableWidgets = new Random().ints(10, 1, 10)
                .mapToObj(i -> new Widget(valueOf(i)))
                .collect(toList());
    }

    public boolean isAvailable(String widgetModel) {
        return this.availableWidgets.stream().anyMatch(widget -> widget.getModelNumber().equals(widgetModel));
    }
}
