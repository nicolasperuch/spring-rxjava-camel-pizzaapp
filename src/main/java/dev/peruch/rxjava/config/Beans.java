package dev.peruch.rxjava.config;

import dev.peruch.rxjava.business.OrderBusiness;
import dev.peruch.rxjava.business.PizzaBusiness;
import dev.peruch.rxjava.model.Orders;
import dev.peruch.rxjava.model.Pizza;
import dev.peruch.rxjava.service.RxService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public RxService rxService(){
        return new RxService();
    }

    @Bean
    public Orders orders() {
        return new Orders();
    }

    @Bean
    public OrderBusiness orderBusiness(){
        return new OrderBusiness();
    }

    @Bean
    public PizzaBusiness pizzaBusiness(){
        return new PizzaBusiness();
    }
}


