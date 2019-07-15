package com.bs.servicefeign.error;

import com.bs.servicefeign.service.CustomerService;

public class CustomerError implements CustomerService {
    @Override
    public String getCustomer(String token) {
        return "Failed to get customer";
    }
}
