package com.example.demospringcloud.order.controller;

import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/testGetUser")
    public Object login(String userName,String password) throws Exception {
        Object result = orderService.testGetUser();
        return result;
    }

    @RequestMapping("/testRegiest")
    public Object testRegiest(String userName,String password){
        Object result = orderService.testRegiest(userName, password);
        return result;
    }

}
