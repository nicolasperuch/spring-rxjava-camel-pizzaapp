package dev.peruch.rxjava.business;

public class PizzaBusiness {

    private final double PIZZA_BIG_VALUE = 30;
    private final double PIZZA_DEFAULT_VALUE = 25;
    private final double STUFFED_EDGE_VALUE = 5;

    public double calculateTotalValue(String size, boolean hasStuffedEdge){
        double currentValue = size.equalsIgnoreCase("g") ? PIZZA_BIG_VALUE : PIZZA_DEFAULT_VALUE;

        if(hasStuffedEdge){
            currentValue += STUFFED_EDGE_VALUE;
        }

        return currentValue;
    }

}
