package com.bs.servicezuul.dao;


import com.bs.servicezuul.entity.CustomerEntity;

public interface CustomerDao {

    CustomerEntity findCustomerByPhoneAndPassword(String phone, String password);

}
