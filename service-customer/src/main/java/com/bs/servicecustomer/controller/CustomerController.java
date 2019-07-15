package com.bs.servicecustomer.controller;


import com.bs.servicecustomer.entity.TokenEntity;
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
    public Map<String, Object> getCustomer(@RequestBody TokenEntity token){
//        System.out.println(token);
        String customerId = token.getToken().split("-")[0];
        System.out.println("==================="+customerId);
        Map<String, Object> resultMap =  customerService.findCustomerById(customerId);
        return resultMap;
    }

}
