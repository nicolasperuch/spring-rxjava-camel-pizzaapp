package dev.peruch.rxjava.business;

import dev.peruch.rxjava.model.Pizza;

public class OrderBusiness {

    private final double PROFIT_MARGIN = 0.3;

    public double calculateDeliveryPrice(Pizza pizza) {
        return pizza.getValue() * PROFIT_MARGIN;
    }

    public double calculateOrderValue(Pizza pizza, double deliveryPrice) {
        return pizza.getValue() + deliveryPrice;
    }


}

