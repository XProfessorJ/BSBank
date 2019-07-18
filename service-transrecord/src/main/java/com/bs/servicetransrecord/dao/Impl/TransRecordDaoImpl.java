package com.bs.servicetransrecord.dao.Impl;

import com.bs.servicetransrecord.dao.TransRecordDao;
import com.bs.servicetransrecord.entity.TransRecordWithDisplayEntity;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransRecordDaoImpl implements TransRecordDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<TransRecordWithDisplayEntity> getTransRecordListByCardId(String cardId, int pagenum, int pagerow){
        int starter = (pagenum-1)*pagerow;
        String sql = "select * from transrecord where cardId = ? limit " + starter + " , " + pagerow;
        List<TransRecordEntity> list = jdbcTemplate.query(sql, new Object[]{cardId}, new BeanPropertyRowMapper(TransRecordEntity.class));
        List<TransRecordWithDisplayEntity> transRecordWithDisplayEntities = new ArrayList<>();
        for (TransRecordEntity transRecord: list) {
            TransRecordWithDisplayEntity transRecordWithDisplay = new TransRecordWithDisplayEntity();
            transRecordWithDisplay.setTransId(transRecord.getTransId());
            transRecordWithDisplay.setCardId(transRecord.getCardId());
            transRecordWithDisplay.setOppositeCardId(transRecord.getOppositeCardId());
            transRecordWithDisplay.setAmount(transRecord.getAmount());
            transRecordWithDisplay.setBalance(transRecord.getBalance());
            transRecordWithDisplay.setInOrOut(transRecord.getInOrOut());
            transRecordWithDisplay.setPostscript(transRecord.getPostscript());
            transRecordWithDisplay.setSettlementDate(transRecord.getSettlementDate());
            transRecordWithDisplay.setSummary(transRecord.getSummary());
            transRecordWithDisplay.setTime(transRecord.getTime());
            String display = "";
            try{
                String querySaving = "select displayAccountNumber from savingcard where cardId = ?";
                display = jdbcTemplate.queryForObject(querySaving, new Object[]{transRecordWithDisplay.getCardId()}, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getString("displayAccountNumber");
                    }
                });
            } catch (Exception e) {
                String querySaving = "select displayAccountNumber from creditcard where cardId = ?";
                display = jdbcTemplate.queryForObject(querySaving, new Object[]{transRecordWithDisplay.getCardId()}, new RowMapper<String>() {
                    @Override
                    public String mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getString("displayAccountNumber");
                    }
                });
            }

            transRecordWithDisplay.setDisplayAccountNumber(display);
            transRecordWithDisplayEntities.add(transRecordWithDisplay);
        }
        if(list != null && list.size()>0){
            return transRecordWithDisplayEntities;
        }else{
            return null;
        }
    }

    @Override
    public int countRecordsByCardId(String cardId){
        String sql = "select COUNT(*) from transrecord where cardId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cardId}, Integer.class);
    }



}
