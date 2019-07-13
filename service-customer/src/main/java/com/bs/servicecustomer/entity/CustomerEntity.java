package com.bs.servicecustomer.entity;

public class CustomerEntity {

    String customerId;
    String customerType;
    String names;
    String gender;
    String prefix;

    public CustomerEntity() {
    }

    public CustomerEntity(String customerId, String customerType, String names, String gender, String prefix, String suffix, String customerSegment, String partnerCustomerSegment, String phone, String email, String password) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.names = names;
        this.gender = gender;
        this.prefix = prefix;
        this.suffix = suffix;
        this.customerSegment = customerSegment;
        this.partnerCustomerSegment = partnerCustomerSegment;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    String suffix;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getPartnerCustomerSegment() {
        return partnerCustomerSegment;
    }

    public void setPartnerCustomerSegment(String partnerCustomerSegment) {
        this.partnerCustomerSegment = partnerCustomerSegment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String customerSegment;
    String partnerCustomerSegment;
    String phone;
    String email;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
