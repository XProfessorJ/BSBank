package com.bs.servicecard.dao.impl;

import com.bs.servicecard.Entity.CardEntity;
import com.bs.servicecard.Entity.CreditcardEntity;
import com.bs.servicecard.Entity.SavingcardEntity;
import com.bs.servicecard.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */

@Repository
public class CardDaoImpl implements CardDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    @Override
    public String updateCardStatus(String cardId){

        String savingcardSql = "update savingcard set accountstatus=? where cardId=?";
        String creditcardSql = "update creditcard set accountstatus=? where cardId=?";

        int resSavingcard = jdbcTemplate.update(savingcardSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"Frozed");
                preparedStatement.setString(2, cardId);
            }
        });

        int resCreditcard = jdbcTemplate.update(creditcardSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"Frozed");
                preparedStatement.setString(2, cardId);
            }
        });

        if(resSavingcard > 0 || resCreditcard > 0) { return "success"; }
        else{ return "failure"; }
    }
}
