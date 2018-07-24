package dev.peruch.rxjava.config;

import dev.peruch.rxjava.entity.Pizza;
import dev.peruch.rxjava.service.RxService;
import io.reactivex.Observable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public RxService rxService(){
        return new RxService();
    }

}
