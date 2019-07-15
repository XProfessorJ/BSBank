package com.bs.servicefeign.controller;

import com.bs.servicefeign.service.AccountService;
import com.bs.servicefeign.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccountClient {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    AccountService accountService;

    @GetMapping(value = "/queryCards")
    public String getCustomer(@RequestParam String token, @RequestParam String accountId) {
        return accountService.getCustomer(token, accountId);
    }

}

