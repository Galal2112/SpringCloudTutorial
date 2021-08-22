package com.example.springcloud.controller;

import com.example.springcloud.common.TransactionsResponse;
import com.example.springcloud.common.TransactionsRequest;
import com.example.springcloud.sevice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;


    @PostMapping("/bookOrder")
    public TransactionsResponse bookOrder(@RequestBody TransactionsRequest request){
        return service.saveOrder(request);
    }
}
