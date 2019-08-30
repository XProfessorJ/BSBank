package com.bs.servicecustomer.controller;

import com.bs.servicecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customer/{id}")
    @ResponseBody
    public Map<String, Object> getCustomer(@PathVariable("id") String id){
        try {
            Map<String, Object> resultMap =  customerService.findCustomerById(id);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
