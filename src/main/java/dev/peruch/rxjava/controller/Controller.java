package dev.peruch.rxjava.controller;

import dev.peruch.rxjava.model.OrderRequest;
import dev.peruch.rxjava.service.RxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class Controller {

    @Autowired
    RxService service;

    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "Faca seu pedido atraves da url /order";
    }
    
    @RequestMapping("/status/{orderId}")
    public String getOrderStatus(@PathVariable String orderId){
        return service.getOrderStatus(orderId);
    }

    @PostMapping("/order")
    public String postOrder(@RequestBody OrderRequest input){
        service.createOrder(input);
        return "Check /status/" + input.getCustomerName() + input.getFlavor();
    }
}