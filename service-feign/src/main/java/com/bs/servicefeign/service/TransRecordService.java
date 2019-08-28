package com.bs.servicefeign.service;

import com.bs.servicefeign.Entity.CardIdWithTokenEntity;
import com.bs.servicefeign.Entity.PageList;
import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.error.CustomerError;
import com.bs.servicefeign.error.TransRecordError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-transrecord", fallback = TransRecordError.class)
@CrossOrigin
public interface TransRecordService {
    @RequestMapping(value = "/Transrecords/{cardId}/{pagenum}/{pagerow}", method = RequestMethod.GET, produces = {"application/json"})
    public PageList getTransRecordList(@PathVariable("cardId") String cardId, @PathVariable("pagenum") Integer pagenum, @PathVariable("pagerow") Integer pagerow);
}
