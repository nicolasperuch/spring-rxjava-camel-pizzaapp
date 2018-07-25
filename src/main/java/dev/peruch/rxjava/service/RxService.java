package dev.peruch.rxjava.service;

import dev.peruch.rxjava.model.Order;
import dev.peruch.rxjava.model.Pizza;
import io.reactivex.Observable;
import org.springframework.stereotype.Service;

import static java.util.concurrent.TimeUnit.*;

@Service
public class RxService {

    private Observable<Order> pizzaObservable;

    public void createOrder(String size, String flavor, boolean hasStuffedEdge){
        pizzaObservable = Observable.just(new Order(new Pizza(size, flavor, hasStuffedEdge)));
        pizzaObservable.subscribe(o -> System.out.println(o.toString()));
        pizzaObservable.subscribe(o -> o = buscandoIngredientes(o));
        pizzaObservable.subscribe(o -> o = preparandoPizza(o));
        pizzaObservable.subscribe(o -> o = entregaDaPizza(o));
    }

    public String getOrderStatus() {
        final String[] output = new String[1];
        pizzaObservable.subscribe(o -> output[0] = o.getStatus());
        return output[0];
    }

    public Order buscandoIngredientes(Order order) throws InterruptedException {
        working("Buscando Ingredientes", 5, "Ingredientes encontrados!");
        Order LocalOrder = order;
        LocalOrder.setStatus("Ingredientes encontrados");
        return LocalOrder;
    }

    public Order preparandoPizza(Order order) throws InterruptedException {
        working("Preparando a Pizza", 15, "Pizza Finalizada");
        Order LocalOrder = order;
        LocalOrder.setStatus("Pizza Finalizada!");
        return LocalOrder;
    }

    public Order entregaDaPizza(Order order) throws InterruptedException {
        working("Iniciando entrega da pizza", 10, "Entrega finalizada!");
        Order LocalOrder = order;
        LocalOrder.setStatus("Entrega finalizada!");
        return LocalOrder;
    }

    public void working(String inittialMessage, int seconds, String endMessage) throws InterruptedException {
        System.out.println(inittialMessage);
        SECONDS.sleep(seconds);
        System.out.println(endMessage);
    }
}