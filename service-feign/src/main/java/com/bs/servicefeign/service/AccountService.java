package com.bs.servicefeign.service;



import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.error.AccountError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "service-account", fallback = AccountError.class)
@CrossOrigin
public interface AccountService {
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Map<String, Object> getAccount(@PathVariable("id") String id);
}
