package dev.peruch.rxjava.business;

import dev.peruch.rxjava.model.Pizza;

public class BusinessRules {

    private static final double PROFIT_MARGIN = 0.3;
    private static final double PIZZA_BIG_VALUE = 30;
    private static final double PIZZA_DEFAULT_VALUE = 25;
    private static final double STUFFED_EDGE_VALUE = 5;


    public static double calculateDeliveryPrice(Pizza pizza) {
        return pizza.getValue() * PROFIT_MARGIN;
    }

    public static double calculateOrderValue(Pizza pizza, double deliveryPrice) {
        return pizza.getValue() + deliveryPrice;
    }

    public static double calculateTotalValue(String size, boolean hasStuffedEdge){
        double currentValue = size.equalsIgnoreCase("g") ? PIZZA_BIG_VALUE : PIZZA_DEFAULT_VALUE;

        if(hasStuffedEdge){
            currentValue += STUFFED_EDGE_VALUE;
        }

        return currentValue;
    }
}

