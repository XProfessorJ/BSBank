package com.bs.servicefeign.controller;


import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AccountClient {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/queryCards", produces = {"application/json"})
    public String getAccount(@RequestBody AccountWithTokenEntity accountWithTokenEntity) {
        return accountService.getAccount(accountWithTokenEntity);
    }

}

