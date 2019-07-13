package com.bs.servicecustomer.dao.impl;


import com.bs.servicecustomer.dao.CustomerDao;
import com.bs.servicecustomer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDaoImpl implements CustomerDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public CustomerEntity findCustomerById(String customerId) {
        String sql = "select * from customer where customerId = ?";
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
    }
}
