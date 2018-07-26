package dev.peruch.rxjava.service;

import dev.peruch.rxjava.model.Order;
import dev.peruch.rxjava.model.Orders;
import dev.peruch.rxjava.model.Pizza;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class RxService {

    private Disposable disposableOrders;
    @Autowired Orders orders;

    public void createOrder(String customerName, String size, String flavor, boolean hasStuffedEdge) throws InterruptedException {
        disposableOrders = Observable
                            .just(createInternalOrder(customerName, size, flavor, hasStuffedEdge))
                            .subscribeOn(Schedulers.computation())
                            .observeOn(Schedulers.computation())
                            .subscribe(this::workingOnOrder);
    }

    private Order createInternalOrder(String customerName, String size, String flavor, boolean hasStuffedEdge){
        Order order = new Order();
        Pizza pizza = new Pizza(size, flavor, hasStuffedEdge);

        order.setOrderId(customerName+flavor);
        order.setCustomerName(customerName);
        order.setPizza(pizza);

        orders.getOrders().add(order);

        return order;
    }

    private void workingOnOrder(Order order) throws InterruptedException {
        order.setStatus("Processing order");
        sleep(20);
        order.setStatus("Making Pizza");
        sleep(20);
        order.setStatus("Delivering order");
        sleep(20);
        order.setStatus("Order completed");
    }

    private void sleep(int time) throws InterruptedException {
        SECONDS.sleep(time);
    }

    public String getOrderStatus(String orderId) {
        List<Order> specificOrder = orders
                                    .getOrders()
                                    .stream()
                                    .filter(o -> o.getOrderId().equalsIgnoreCase(orderId))
                                    .collect(Collectors.toList());

        return specificOrder.get(0).getStatus();
    }
}