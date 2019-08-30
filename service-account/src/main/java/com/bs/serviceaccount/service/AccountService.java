package com.bs.serviceaccount.service;

import com.bs.serviceaccount.entity.AccountEntity;


import java.util.List;
import java.util.Map;


public interface AccountService {

    AccountEntity findAccountByAccountId(String accountId);

}
