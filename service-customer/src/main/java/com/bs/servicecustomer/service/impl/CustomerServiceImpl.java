package com.bs.servicecustomer.service.impl;


import com.bs.servicecustomer.dao.CustomerDao;
import com.bs.servicecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public Map<String, Object> findCustomerById(String customerId) {
        Map<String, Object> map = new HashMap<>();
        map.put("customer", customerDao.findCustomerById(customerId));
        map.put("accounts", customerDao.getAccountsByCustomerId(customerId));
        return map;
    }
}
