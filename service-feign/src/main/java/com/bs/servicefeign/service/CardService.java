package com.bs.servicefeign.service;

import com.bs.servicefeign.error.CardError;
import com.bs.servicefeign.error.CustomerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */

@FeignClient(value = "service-card", fallback = CardError.class)
@CrossOrigin
public interface CardService {
    @RequestMapping(value = "/cards/{accountId}", method = RequestMethod.GET)
    public Map<String, Object> getCardsByAccountId(@PathVariable("accountId") String accountId);
}

