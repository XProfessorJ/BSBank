package com.bs.servicecustomer.controller;


import com.bs.servicecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/customerHome")
    public String getCustomer(@RequestParam(value = "customerId", defaultValue = "1") String customerId){
        return customerService.findCustomerById(customerId).getPhone();
    }

}
