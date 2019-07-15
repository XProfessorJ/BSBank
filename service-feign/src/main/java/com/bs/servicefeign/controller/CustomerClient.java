package com.bs.servicefeign.controller;

import com.bs.servicefeign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerClient {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customerDashboard")
    public String sayHi(@RequestParam String token) {
        return customerService.sayHiFromClientOne(token);
    }
}

