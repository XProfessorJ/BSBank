package com.bs.servicetransrecord.entity;

import java.sql.Timestamp;

public class CreditcardEntity extends CardEntity{

    double requestedCreditLimitAmount;
    Timestamp creditLimitIncreaseStartDate;

    public double getRequestedCreditLimitAmount() {
        return requestedCreditLimitAmount;
    }

    public void setRequestedCreditLimitAmount(double requestedCreditLimitAmount) {
        this.requestedCreditLimitAmount = requestedCreditLimitAmount;
    }

    public Timestamp getCreditLimitIncreaseStartDate() {
        return creditLimitIncreaseStartDate;
    }

    public void setCreditLimitIncreaseStartDate(Timestamp creditLimitIncreaseStartDate) {
        this.creditLimitIncreaseStartDate = creditLimitIncreaseStartDate;
    }

    public Timestamp getCreditLimitIncreaseEndDate() {
        return creditLimitIncreaseEndDate;
    }

    public void setCreditLimitIncreaseEndDate(Timestamp creditLimitIncreaseEndDate) {
        this.creditLimitIncreaseEndDate = creditLimitIncreaseEndDate;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    Timestamp creditLimitIncreaseEndDate;

    public CreditcardEntity(String cardId, String productName, String profuctCode, String accountNickname, String displayAccountNumber, String currencyCode, String accountClassification, String accountStatus, double currentBalance, double availableBalance, String accountId, double requestedCreditLimitAmount, Timestamp creditLimitIncreaseStartDate, Timestamp creditLimitIncreaseEndDate, String reasonCode) {
        super(cardId, productName, profuctCode, accountNickname, displayAccountNumber, currencyCode, accountClassification, accountStatus, currentBalance, availableBalance, accountId);
        this.requestedCreditLimitAmount = requestedCreditLimitAmount;
        this.creditLimitIncreaseStartDate = creditLimitIncreaseStartDate;
        this.creditLimitIncreaseEndDate = creditLimitIncreaseEndDate;
        this.reasonCode = reasonCode;
    }

    String reasonCode;

}
