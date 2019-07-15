package com.bs.servicecustomer.service;

import com.bs.servicecustomer.entity.CustomerEntity;

import java.util.Map;

public interface CustomerService {

    Map<String, Object> findCustomerById(String customerId);

}
