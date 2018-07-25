package dev.peruch.rxjava.model;

public class Order {

    private Pizza pizza;
    private double deliveryPrice;
    private double orderValue;
    private String status;

    public Order(Pizza pizza) {
        this.pizza = pizza;
        this.deliveryPrice = calculateDeliveryPrice();
        this.orderValue = calculateOrderValue();
        this.status = "";
    }

    public double calculateDeliveryPrice() {
        return this.pizza.getValue() * 0.1;
    }

    public double calculateOrderValue() {
        return this.pizza.getValue() + this.deliveryPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza.toString() +
                ", deliveryPrice=" + deliveryPrice +
                ", orderValue=" + orderValue +
                '}';
    }
}
