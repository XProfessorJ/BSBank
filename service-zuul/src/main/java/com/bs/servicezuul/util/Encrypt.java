package com.bs.servicezuul.util;

import com.bs.servicezuul.dao.CustomerDao;
import com.bs.servicezuul.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Encrypt {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

    @Autowired
    CustomerDao customerDao;

    public String getTokenByCustomerId(String customerId){
        return stringRedisTemplate.opsForValue().get(customerId);
    }

    public String generateToken(String phone, String password){
        CustomerEntity customerEntity =  customerDao.findCustomerByPhoneAndPassword(phone, password);
        if (customerEntity == null) {
            return null;
        }
        String token = customerEntity.getCustomerId() + "-" + customerEntity.getPassword();
        stringRedisTemplate.opsForValue().set(customerEntity.getCustomerId(), token);
        return token;
    }

}
