package com.bs.servicezuul.service;

import com.bs.servicezuul.entity.CustomerEntity;

import java.util.Map;

public interface CustomerService {

    public CustomerEntity findCustomerByPhoneAndPassword(String phone, String password);

}
