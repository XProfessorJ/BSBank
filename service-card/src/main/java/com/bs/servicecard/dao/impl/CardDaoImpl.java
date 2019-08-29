package com.bs.servicecard.dao.impl;

import com.bs.servicecard.Entity.CreditcardEntity;
import com.bs.servicecard.Entity.SavingcardEntity;
import com.bs.servicecard.dao.CardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public boolean addSavingCard(String cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currencyCode, String accountClassification, String accountId){

        try {
            int result = jdbcTemplate.update("INSERT INTO savingcard (cardId, productName, productCode, accountNickName, displayAccountNumber, currencyCode, accountClassification, accountStatus, currentBalance, availableBalance, accountId) VALUES (?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,cardId);
                    ps.setString(2, productName);
                    ps.setString(3, productCode);
                    ps.setString(4, accountNickName);
                    ps.setString(5, displayAccountNumber);
                    ps.setString(6, currencyCode);
                    ps.setString(7, accountClassification);
                    ps.setString(8, "Active");
                    ps.setString(9, "0");
                    ps.setString(10, "0");
                    ps.setString(11, accountId);
                }
            });
            if(result<0){
                return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addCreditCard(String cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currencyCode, String accountClassification, Date creditLimitIncreaseStartDate, Date creditLimitIncreaseEndDate, String reasonCode, String accountId){

        try {
            int result = jdbcTemplate.update("INSERT INTO creditcard (cardId, productName, productCode, accountNickName, displayAccountNumber, currencyCode, accountClassification, accountStatus, currentBalance, availableBalance, requestedCreditLimitAmount, creditLimitIncreaseStartDate, creditLimitIncreaseEndDate, reasonCode, accountId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1,cardId);
                    ps.setString(2, productName);
                    ps.setString(3, productCode);
                    ps.setString(4, accountNickName);
                    ps.setString(5, displayAccountNumber);
                    ps.setString(6, currencyCode);
                    ps.setString(7, accountClassification);
                    ps.setString(8, "Active");
                    ps.setString(9, "0");
                    ps.setString(10, "0");
                    ps.setString(11, "5000");

                    SimpleDateFormat stateDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat endDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String stringCreditLimitIncreaseStartDate = stateDateFormatter.format(creditLimitIncreaseStartDate);
                    String stringCreditLimitIncreaseEndDate = endDateFormatter.format(creditLimitIncreaseEndDate);
                    ps.setString(12, stringCreditLimitIncreaseStartDate);
                    ps.setString(13, stringCreditLimitIncreaseEndDate);

                    ps.setString(14, reasonCode);
                    ps.setString(15, accountId);

                }
            });
            if(result<0){
                return false;
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }



    @Override
    public String updateCardStatus(String cardId){

        String savingcardSql = "update savingcard set accountstatus=? where cardId=?";
        String creditcardSql = "update creditcard set accountstatus=? where cardId=?";

        int resSavingcard = jdbcTemplate.update(savingcardSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"Frozen");
                preparedStatement.setString(2, cardId);
            }
        });

        int resCreditcard = jdbcTemplate.update(creditcardSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,"Frozen");
                preparedStatement.setString(2, cardId);
            }
        });

        if (resSavingcard > 0 || resCreditcard > 0) {
            return "success";
        } else {
            return "failure";
        }
    }
}
