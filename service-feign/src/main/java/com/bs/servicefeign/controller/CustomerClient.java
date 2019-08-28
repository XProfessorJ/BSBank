package com.bs.servicefeign.controller;

import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class CustomerClient {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer/{id}",method = RequestMethod.GET)
    public Map<String, Object> getCustomer(@PathVariable("id") String id) {
        return customerService.getCustomer(id);
    }

}

