package com.bs.servicezuul.service.impl;

import com.bs.servicezuul.dao.CustomerDao;
import com.bs.servicezuul.entity.CustomerEntity;
import com.bs.servicezuul.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public CustomerEntity findCustomerByPhoneAndPassword(String phone, String password) {
        CustomerEntity customerEntity = customerDao.findCustomerByPhoneAndPassword(phone, password);
        return customerEntity;
    }
}
