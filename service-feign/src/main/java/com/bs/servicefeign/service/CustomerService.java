package com.bs.servicefeign.service;

import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.error.CustomerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-customer", fallback = CustomerError.class)
@CrossOrigin
public interface CustomerService {
    @RequestMapping(value = "/customerDashboard",method = RequestMethod.POST)
    String getCustomer(@RequestBody TokenEntity token);
}
