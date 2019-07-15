package com.bs.servicezuul.controller;


import com.bs.servicezuul.entity.CustomerEntity;
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

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody CustomerEntity customerEntity){
        String token =  encrypt.generateToken(customerEntity.getPhone(), customerEntity.getPassword());
        Map<String, Object> resultMap = new HashMap<>();
        if (token == null) {
            resultMap.put("error", "Phone or password is wrong!");
        }
        resultMap.put("token", token);
        return resultMap;
    }

}
