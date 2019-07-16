package com.bs.servicezuul.util;

import com.bs.servicezuul.dao.CustomerDao;
import com.bs.servicezuul.entity.CustomerEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

@Component
public class Encrypt {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作 k-v 字符串

    @Autowired
    CustomerDao customerDao;

    private final byte[] DESIV = new byte[] { 0x12, 0x34, 0x56, 120, (byte) 0x90, (byte) 0xab, (byte) 0xcd, (byte) 0xef };// 向量
    private AlgorithmParameterSpec iv = null;// 加密算法的参数接口
    private Key key = null;
    private String charset = "utf-8";

    public String getTokenByCustomerId(String customerId){
        return stringRedisTemplate.opsForValue().get(customerId);
    }

    public String generateToken(String phone, String password){
        CustomerEntity customerEntity =  customerDao.findCustomerByPhoneAndPassword(phone, password);
        if (customerEntity == null) {
            return null;
        }
        String originToken = customerEntity.getCustomerId() + "-" + customerEntity.getPassword();
        if (StringUtils.isNotBlank(charset)) {
            this.charset = charset;
        }
        try{
            String key = "9ba45bfd500642328ec03ad8ef1b6e75";// 自定义密钥
            EncryptUtil des = new EncryptUtil(key, "utf-8");
            String token = des.encode(originToken);
            stringRedisTemplate.opsForValue().set(customerEntity.getCustomerId(), token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            return "generate token failed";
        }


    }





}
