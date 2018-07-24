package dev.peruch.rxjava.controller;

import dev.peruch.rxjava.service.RxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    RxService service;

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "Faca seu pedido atraves da url /order";
    }

    @RequestMapping("/order/{size}/{flavor}/{hasStuffedEdge}")
    public String createOrder(@PathVariable String size,
                              @PathVariable String flavor,
                              @PathVariable boolean hasStuffedEdge) {
        service.createOrder(size, flavor, hasStuffedEdge);
        return "OK";
    }

    @RequestMapping("/status")
    public String getOrderStatus() {
        return service.getOrderStatus();
    }
}