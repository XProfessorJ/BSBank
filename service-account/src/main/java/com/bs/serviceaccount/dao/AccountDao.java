package com.bs.serviceaccount.dao;

import com.bs.serviceaccount.entity.AccountEntity;

public interface AccountDao {

    AccountEntity findAccountByAccountId(String accountId);

}
