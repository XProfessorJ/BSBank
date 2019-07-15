package com.bs.servicecustomer.dao.impl;


import com.bs.servicecustomer.dao.CustomerDao;
import com.bs.servicecustomer.entity.AccountEntity;
import com.bs.servicecustomer.entity.CustomerEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public CustomerEntity findCustomerById(String customerId) {
        String sql = "select * from customer where customerId = ?";
        try{
            CustomerEntity customerEntity = jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new RowMapper<CustomerEntity>() {
                @Override
                public CustomerEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                    CustomerEntity customer = new CustomerEntity();
                    customer.setCustomerId(resultSet.getString("customerId"));
                    customer.setCustomerType(resultSet.getString("customerType"));
                    customer.setNames(resultSet.getString("names"));
                    customer.setGender(resultSet.getString("gender"));
                    customer.setPrefix(resultSet.getString("prefix"));
                    customer.setSuffix(resultSet.getString("suffix"));
                    customer.setCustomerSegment(resultSet.getString("customerSegment"));
                    customer.setPartnerCustomerSegment(resultSet.getString("partnerCustomerSegment"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPassword(resultSet.getString("password"));
                    return customer;
                }
            });
            return customerEntity;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public List<AccountEntity> getAccountsByCustomerId(String customerId) {
        String sql = "select * from account where accountId in (select accountId from customer_account where customerId = ?)";
        List<AccountEntity> accountEntityList = jdbcTemplate.query(sql, new Object[]{customerId}, new BeanPropertyRowMapper(AccountEntity.class));
        return accountEntityList;
    }

}
