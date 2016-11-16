package com.wgrus.reactive.billing;

public class CheckedCustomer {

    private String customerId;
    private Boolean accepted;

    public CheckedCustomer(String customerId, Boolean accepted) {
        this.customerId = customerId;
        this.accepted = accepted;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    @Override
    public String toString() {
        return "CheckedCustomer{" +
                "customerId='" + customerId + '\'' +
                ", accepted='" + accepted + '\'' +
                '}';
    }
}
