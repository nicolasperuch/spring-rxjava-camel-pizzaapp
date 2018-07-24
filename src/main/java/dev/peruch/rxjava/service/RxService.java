package dev.peruch.rxjava.service;

import dev.peruch.rxjava.entity.Pizza;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

@Service
public class RxService {

    private Observable<String> pizzaObservable;


    public void createOrder(String size, String flavor, boolean hasStuffedEdge){
        Observable<Pizza> sampleObservable = Observable.just(new Pizza(size, flavor, hasStuffedEdge));
        sampleObservable.subscribe(p -> System.out.println(p.toString()));
        sampleObservable.subscribe(p -> buscandoIngredientes(p));
        sampleObservable.subscribe(p -> preparandoPizza(p));
//        sampleObservable.subscribe(p -> entregaDaPizza());
//        sampleObservable.subscribe(p -> pedidoFinalizado());
    }

    public void buscandoIngredientes(Pizza pizza) throws InterruptedException {
        working("Buscando Ingredientes", 5);
    }

    public void preparandoPizza(Pizza pizza) {
        System.out.println("Comecando a Pizza");
    }


    public void working(String message, int seconds) throws InterruptedException {
        System.out.println(message);
        SECONDS.sleep(seconds);
        System.out.println("Ok - " + message);
    }

}
