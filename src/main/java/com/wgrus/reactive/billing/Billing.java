package com.wgrus.reactive.billing;

import com.wgrus.reactive.orders.received.ReceivedOrder;

import java.util.Random;

public class Billing {

    public Boolean checkCustomerForOrder(ReceivedOrder order) {
        return new Random().nextBoolean();
    }
}
