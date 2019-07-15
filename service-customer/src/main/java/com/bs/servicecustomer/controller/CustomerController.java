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

    @RequestMapping("/customerDashboard")
    @ResponseBody
    public Map<String, Object> getCustomer(@RequestParam(value = "token") String token){
        String customerId = token.split("-")[0];
        Map<String, Object> resultMap =  customerService.findCustomerById(customerId);
        return resultMap;
    }

}
