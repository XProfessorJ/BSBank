package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.service.CustomerService;

import java.util.Map;

public class CustomerError implements CustomerService {

    @Override
    public Map<String, Object> getCustomer(String id) {
        return null;
    }
}
