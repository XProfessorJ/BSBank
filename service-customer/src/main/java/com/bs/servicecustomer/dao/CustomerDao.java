package com.bs.servicecustomer.dao;

import com.bs.servicecustomer.entity.CustomerEntity;

public interface CustomerDao {

    CustomerEntity findCustomerById(String customerId);

}
