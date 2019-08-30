package com.bs.servicefeign.service;

import com.bs.servicefeign.error.CustomerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "service-customer", fallback = CustomerError.class)
@CrossOrigin
public interface CustomerService {
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Map<String, Object> getCustomer(@PathVariable("id") String id);
}
