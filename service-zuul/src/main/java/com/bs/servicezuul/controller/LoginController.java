package com.bs.servicezuul.controller;


import com.bs.servicezuul.entity.CustomerEntity;
import com.bs.servicezuul.service.CustomerService;
import com.bs.servicezuul.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    Encrypt encrypt;

    @Autowired
    CustomerService customerService;



    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody CustomerEntity customerEntity){
        String token =  encrypt.generateToken(customerEntity.getPhone(), customerEntity.getPassword());
        Map<String, Object> resultMap = new HashMap<>();
        if (token == null) {
            resultMap.put("error", "Phone or password is wrong!");
        } else{
            System.out.println(token);
            resultMap.put("customer", customerService.findCustomerByPhoneAndPassword(customerEntity.getPhone(), customerEntity.getPassword()));
            resultMap.put("token", token);
            // 用户偏好逻辑


        }
        return resultMap;
    }

}
