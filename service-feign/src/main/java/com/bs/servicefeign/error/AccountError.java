package com.bs.servicefeign.error;


import com.bs.servicefeign.Entity.AccountWithTokenEntity;

import com.bs.servicefeign.service.AccountService;

import java.util.Map;

public class AccountError implements AccountService {


    @Override
    public Map<String, Object> getAccount(String id) {
        return null;
    }
}
