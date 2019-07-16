package com.bs.serviceaccount.dao.impl;


import com.bs.serviceaccount.dao.AccountDao;
import com.bs.serviceaccount.entity.AccountEntity;
import com.bs.serviceaccount.entity.CreditcardEntity;
import com.bs.serviceaccount.entity.SavingcardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, List> getCardsByAccountId(String accountId) {
        String savingcardSql = "select * from savingcard where accountId = ?";
        String creditcardSql = "select * from creditcard where accountId = ?";
        List<SavingcardEntity> savingcardList = jdbcTemplate.query(savingcardSql, new Object[]{accountId}, new BeanPropertyRowMapper(SavingcardEntity.class));
        List<CreditcardEntity> creditcardList = jdbcTemplate.query(creditcardSql, new Object[]{accountId}, new BeanPropertyRowMapper(CreditcardEntity.class));
        Map<String, List> map = new HashMap<>();
        map.put("savingcards", savingcardList);
        map.put("creditcards", creditcardList);
        return map;
    }


}
