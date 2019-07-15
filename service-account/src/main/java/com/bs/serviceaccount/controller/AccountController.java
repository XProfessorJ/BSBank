package com.bs.serviceaccount.controller;


import com.bs.serviceaccount.entity.AccountEntity;
import com.bs.serviceaccount.entity.AccountWithTokenEntity;
import com.bs.serviceaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/queryCards", produces = {"application/json"})
    @ResponseBody
    public Map<String, Object> getAccount(@RequestBody AccountWithTokenEntity accountWithTokenEntity){
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, List> cardMap =  accountService.getCardsByAccountId(accountWithTokenEntity.getAccountId());
        AccountEntity account = accountService.findAccountByAccountId(accountWithTokenEntity.getAccountId());
        resultMap.put("account", account);
        resultMap.put("cards", cardMap);
        return resultMap;
    }

}
