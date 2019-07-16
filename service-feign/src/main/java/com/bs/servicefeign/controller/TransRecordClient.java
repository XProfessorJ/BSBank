package com.bs.servicefeign.controller;

import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.Entity.CardIdWithTokenEntity;
import com.bs.servicefeign.service.AccountService;
import com.bs.servicefeign.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class TransRecordClient {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    TransRecordService transRecordService;

    @PostMapping(value = "/transRecord", produces = {"application/json"})
    public String getAccount(@RequestBody CardIdWithTokenEntity cardIdWithTokenEntity) {
        return transRecordService.getTransRecordList(cardIdWithTokenEntity);
    }
}
