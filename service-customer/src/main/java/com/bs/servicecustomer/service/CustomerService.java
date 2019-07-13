package com.bs.servicecustomer.service;

import com.bs.servicecustomer.entity.CustomerEntity;

public interface CustomerService {

    CustomerEntity findCustomerById(String customerId);

}
