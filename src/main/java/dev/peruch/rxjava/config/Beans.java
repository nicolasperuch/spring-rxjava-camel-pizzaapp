package dev.peruch.rxjava.config;

import dev.peruch.rxjava.service.RxService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public RxService rxService(){
        return new RxService();
    }

}
