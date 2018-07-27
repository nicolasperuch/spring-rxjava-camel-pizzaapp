package dev.peruch.rxjava.model;

import dev.peruch.rxjava.business.OrderBusiness;
import org.springframework.beans.factory.annotation.Autowired;

public class Order {

    @Autowired
    OrderBusiness orderBusiness;
    private String orderId;
    private Pizza pizza;
    private double deliveryPrice;
    private double orderValue;
    private String status;
    private String customerName;

    public Order(Pizza pizza, String customerName) {
        this.pizza = pizza;
        this.deliveryPrice = orderBusiness.calculateDeliveryPrice(this.pizza);
        this.orderValue = orderBusiness.calculateOrderValue(this.pizza, deliveryPrice);
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
                ", pizza=" + pizza.toString() +
                ", deliveryPrice=" + deliveryPrice +
                ", orderValue=" + orderValue +
                ", status='" + status + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
