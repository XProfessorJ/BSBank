package com.bs.serviceaccount.service.impl;


import com.bs.serviceaccount.dao.AccountDao;
import com.bs.serviceaccount.entity.AccountEntity;
import com.bs.serviceaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public AccountEntity findAccountByAccountId(String accountId) {
        return accountDao.findAccountByAccountId(accountId);
    }

}
