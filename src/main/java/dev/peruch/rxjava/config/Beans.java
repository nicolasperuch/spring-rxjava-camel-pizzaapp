package dev.peruch.rxjava.config;

import dev.peruch.rxjava.business.BusinessRules;
import dev.peruch.rxjava.model.Orders;
import dev.peruch.rxjava.service.RxService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
    public BusinessRules businessRules(){
        return new BusinessRules();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*");
            }
        };
    }
}


