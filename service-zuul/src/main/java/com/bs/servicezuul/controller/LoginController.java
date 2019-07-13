package com.bs.servicezuul.controller;


import com.bs.servicezuul.entity.CustomerEntity;
import com.bs.servicezuul.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    Encrypt encrypt;

    @PostMapping(value = "/login")
    public String login(@RequestBody CustomerEntity customerEntity){
        String token =  encrypt.generateToken(customerEntity.getPhone(), customerEntity.getPassword());
        return token;
    }

}
