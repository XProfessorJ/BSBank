package com.bs.servicefeign.error;

import com.bs.servicefeign.service.AccountService;

public class AccountError implements AccountService {
    @Override
    public String getCustomer(String token, String accountId) {
        return "Failed to get account";
    }
}
