package dev.peruch.rxjava.model;

public class Order {

    private String orderId;
    private Pizza pizza;
    private double deliveryPrice;
    private double orderValue;
    private String status;
    private String customerName;

    public Order(Pizza pizza, String customerName) {
        this.pizza = pizza;
        this.deliveryPrice = calculateDeliveryPrice();
        this.orderValue = calculateOrderValue();
        this.status = "";
        this.customerName = customerName;
    }

    public Order() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double calculateDeliveryPrice() {
        return this.pizza.getValue() * 0.1;
    }

    public double calculateOrderValue() {
        return this.pizza.getValue() + this.deliveryPrice;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", pizza=" + pizza +
                ", deliveryPrice=" + deliveryPrice +
                ", orderValue=" + orderValue +
                ", status='" + status + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
