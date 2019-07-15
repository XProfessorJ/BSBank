package com.bs.servicefeign.service;



import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.error.AccountError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-account", fallback = AccountError.class)
@CrossOrigin
public interface AccountService {
    @RequestMapping(value = "/queryCards",method = RequestMethod.POST, produces = {"application/json"})
    String getAccount(@RequestBody AccountWithTokenEntity accountWithTokenEntity);
}
