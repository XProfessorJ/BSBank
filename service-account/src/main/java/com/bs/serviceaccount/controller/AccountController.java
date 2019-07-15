package com.bs.serviceaccount.controller;


import com.bs.serviceaccount.entity.AccountEntity;
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

    @RequestMapping("/queryCards")
    @ResponseBody
    public Map<String, Object> getAccount(@RequestParam(value = "token") String token, @RequestParam(value = "accountId") String accountId){
        Map<String, Object> resultMap = new HashMap<>();
        AccountEntity account = accountService.findAccountByAccountId(accountId);
        Map<String, List> cardMap =  accountService.getCardsByAccountId(accountId);
        resultMap.put("account", account);
        resultMap.put("cards", cardMap);
        return resultMap;
    }

}
