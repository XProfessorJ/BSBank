package com.bs.servicetransrecord.controller;

import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transrecord")
public class TransRecordController {

    @Autowired
    TransRecordService transRecordService;

    @RequestMapping(value = "/{cardid}",method = RequestMethod.GET)
    public List<TransRecordEntity> getTransRecordListByCardId(@PathVariable("cardid") String cardId){
        return transRecordService.getTransRecordListByCardId(cardId);
    }

}
