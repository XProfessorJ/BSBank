package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.TokenEntity;
import com.bs.servicefeign.service.CustomerService;

public class CustomerError implements CustomerService {
    @Override
    public String getCustomer(TokenEntity token) {
        return "Failed to get customer";
    }
}
