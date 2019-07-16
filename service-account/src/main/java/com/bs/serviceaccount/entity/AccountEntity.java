package com.bs.serviceaccount.entity;

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

    public AccountEntity(String accountId, String accountType, String accountStatus) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    String accountStatus;

    public AccountEntity() {
    }

}
