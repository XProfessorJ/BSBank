package com.bs.servicecustomer.entity;

public class AccountEntity {

    String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    String accountType;

    public AccountEntity() {
    }

    public AccountEntity(String accountId, String accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }
}
