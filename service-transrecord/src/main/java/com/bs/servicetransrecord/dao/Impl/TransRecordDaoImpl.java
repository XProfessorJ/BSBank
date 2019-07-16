package com.bs.servicetransrecord.dao.Impl;

import com.bs.servicetransrecord.dao.TransRecordDao;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TransRecordDaoImpl implements TransRecordDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<TransRecordEntity> getTransRecordListByCardId(String cardId){
        List<TransRecordEntity> list = jdbcTemplate.query("select * from transrecord where cardId = ?", new Object[]{cardId}, new BeanPropertyRowMapper(TransRecordEntity.class));
        if(list != null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }


}
