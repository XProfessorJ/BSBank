package com.bs.serviceaccount.dao.impl;


import com.bs.serviceaccount.dao.AccountDao;
import com.bs.serviceaccount.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AccountEntity findAccountByAccountId(String accountId) {
        String sql = "select * from account where accountId = ?";
        AccountEntity accountEntity = jdbcTemplate.queryForObject(sql, new Object[]{accountId}, new RowMapper<AccountEntity>(){
            @Override
            public AccountEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                AccountEntity account = new AccountEntity();
                account.setAccountId(resultSet.getString("accountId"));
                account.setAccountType(resultSet.getString("accountType"));
                account.setAccountStatus(resultSet.getString("accountStatus"));
                return account;
            }
        });
        return accountEntity;
    }


}
