package com.bs.servicefeign.controller;

import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.Entity.CardIdWithTokenEntity;
import com.bs.servicefeign.Entity.PageList;
import com.bs.servicefeign.service.AccountService;
import com.bs.servicefeign.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class TransRecordClient {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    TransRecordService transRecordService;

    @RequestMapping(value = "/Transrecords/{cardId}/{pagenum}/{pagerow}", method = RequestMethod.GET, produces = {"application/json"})
    public PageList getTransRecordList(@PathVariable("cardId") String cardId, @PathVariable("pagenum") Integer pagenum, @PathVariable("pagerow") Integer pagerow) {
        return transRecordService.getTransRecordList(cardId, pagenum, pagerow);
    }
}
