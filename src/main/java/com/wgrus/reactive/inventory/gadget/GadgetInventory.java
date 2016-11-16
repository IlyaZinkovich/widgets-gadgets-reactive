package com.wgrus.reactive.inventory.gadget;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class GadgetInventory {

    private List<Gadget> availableGadgets;

    public GadgetInventory() {
        this.availableGadgets = IntStream.range(1, 6)
                .mapToObj(i -> new Gadget(valueOf(i)))
                .collect(toList());
    }

    public boolean isAvailable(String gadgetModel) {
        return this.availableGadgets.stream()
                .anyMatch(gadget -> gadget.getModelNumber().equals(gadgetModel));
    }
}
