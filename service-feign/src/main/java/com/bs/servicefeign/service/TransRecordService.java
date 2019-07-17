package com.bs.servicefeign.service;

import com.bs.servicefeign.Entity.CardIdWithTokenEntity;
import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.error.CustomerError;
import com.bs.servicefeign.error.TransRecordError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-transrecord", fallback = TransRecordError.class)
@CrossOrigin
public interface TransRecordService {
    @RequestMapping(value = "/queryTransrecords", method = RequestMethod.POST, produces = {"application/json"})
    String getTransRecordList(@RequestBody CardIdWithTokenEntity cardIdWithTokenEntity);
}
