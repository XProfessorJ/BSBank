package com.bs.servicecustomer.dao;

import com.bs.servicecustomer.entity.AccountEntity;
import com.bs.servicecustomer.entity.CustomerEntity;

import java.util.List;

public interface CustomerDao {

    CustomerEntity findCustomerById(String customerId);
    List<AccountEntity> getAccountsByCustomerId(String customerId);

}
