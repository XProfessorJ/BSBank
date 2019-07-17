package com.bs.servicetransrecord.controller;


import com.bs.servicetransrecord.entity.CardIdWithTokenEntity;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransRecordController {

    @Autowired
    TransRecordService transRecordService;

    @RequestMapping(value = "/queryTransrecords", produces = {"application/json"})
    @ResponseBody
    public List<TransRecordEntity> getTransRecordList(@RequestBody CardIdWithTokenEntity cardIdWithTokenEntity){
        return transRecordService.getTransRecordListByCardId(cardIdWithTokenEntity.getCardId());
    }

}
