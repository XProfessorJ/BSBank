package com.bs.servicecard.Entity;

public class CardEntity {

    String cardId;
    String productName;
    String productCode;
    String accountNickname;
    String displayAccountNumber;
    String currencyCode;
    String accountClassification;

    public CardEntity() {
    }

    public CardEntity(String cardId, String productName, String profuctCode, String accountNickname, String displayAccountNumber, String currencyCode, String accountClassification, String accountStatus, double currentBalance, double availableBalance, String accountId) {
        this.cardId = cardId;
        this.productName = productName;
        this.productCode = profuctCode;
        this.accountNickname = accountNickname;
        this.displayAccountNumber = displayAccountNumber;
        this.currencyCode = currencyCode;
        this.accountClassification = accountClassification;
        this.accountStatus = accountStatus;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.accountId = accountId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String profuctCode) {
        this.productCode = profuctCode;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public void setAccountNickname(String accountNickname) {
        this.accountNickname = accountNickname;
    }

    public String getDisplayAccountNumber() {
        return displayAccountNumber;
    }

    public void setDisplayAccountNumber(String displayAccountNumber) {
        this.displayAccountNumber = displayAccountNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAccountClassification() {
        return accountClassification;
    }

    public void setAccountClassification(String accountClassification) {
        this.accountClassification = accountClassification;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    String accountStatus;
    double currentBalance;
    double availableBalance;
    String accountId;

}
