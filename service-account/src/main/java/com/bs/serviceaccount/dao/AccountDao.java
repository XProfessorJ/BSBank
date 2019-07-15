package com.bs.serviceaccount.dao;

import com.bs.serviceaccount.entity.AccountEntity;

import java.util.List;
import java.util.Map;

public interface AccountDao {

    AccountEntity findAccountByAccountId(String accountId);
    Map<String, List> getCardsByAccountId(String accountId);

}
