package com.bs.servicefeign.error;


import com.bs.servicefeign.Entity.AccountWithTokenEntity;

import com.bs.servicefeign.service.AccountService;

public class AccountError implements AccountService {
    @Override
    public String getAccount(AccountWithTokenEntity accountWithTokenEntity) {
        return "Failed to get account";
    }
}
