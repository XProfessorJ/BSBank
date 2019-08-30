package com.bs.servicezuul.service;

import com.bs.servicezuul.entity.CustomerEntity;

public interface CustomerService {

    public CustomerEntity findCustomerByPhoneAndPassword(String phone, String password);

}
