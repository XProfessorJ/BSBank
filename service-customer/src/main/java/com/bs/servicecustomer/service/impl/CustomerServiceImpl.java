package com.bs.servicecustomer.service.impl;


import com.bs.servicecustomer.dao.CustomerDao;
import com.bs.servicecustomer.entity.CustomerEntity;
import com.bs.servicecustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;


    @Override
    public CustomerEntity findCustomerById(String customerId) {
        return customerDao.findCustomerById(customerId);
    }
}
