package com.wgrus.reactive.system;

import com.wgrus.reactive.input.InputOrder;

import java.util.List;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class OrderTransformer {

    private static Long orderIdCounter = 1L;

    public Order transform(InputOrder inputOrder, OrderItem.Type orderType) {
        List<OrderItem> transformedOrderItems = inputOrder.getOrderedItems().stream()
                .map(inputOrderItem -> new OrderItem(inputOrderItem.getModelNumber(), orderType))
                .collect(toList());
        return new Order(valueOf(orderIdCounter++), inputOrder.getCustomerId(),
                transformedOrderItems);
    }
}
