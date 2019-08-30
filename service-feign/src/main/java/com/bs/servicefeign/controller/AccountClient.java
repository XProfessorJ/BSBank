package com.bs.servicefeign.controller;

import com.bs.servicefeign.service.AccountService;
import com.bs.servicefeign.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AccountClient {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    AccountService accountService;

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Map<String, Object> getAccount(@PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<>();
        map.putAll(accountService.getAccount(id));
        map.putAll(cardService.getCardsByAccountId(id));
        return map;
    }

}

