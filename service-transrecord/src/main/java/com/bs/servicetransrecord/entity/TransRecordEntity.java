package com.bs.servicetransrecord.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TransRecordEntity {

    String transId;
    String cardId;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    String oppositeCardId;
    Timestamp time;
    String inOrOut;

    public TransRecordEntity(String transId, String cardId, String oppositeCardId, Timestamp time, String inOrOut, double amount, double balance, double summary, String postscript, Date settlementDate) {
        this.transId = transId;
        this.cardId = cardId;
        this.oppositeCardId = oppositeCardId;
        this.time = time;
        this.inOrOut = inOrOut;
        this.amount = amount;
        this.balance = balance;
        this.summary = summary;
        this.postscript = postscript;
        this.settlementDate = settlementDate;
    }

    public TransRecordEntity() {
    }

    double amount;
    double balance;
    double summary;
    String postscript;
    Date settlementDate;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getOppositeCardId() {
        return oppositeCardId;
    }

    public void setOppositeCardId(String oppositeCardId) {
        this.oppositeCardId = oppositeCardId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSummary() {
        return summary;
    }

    public void setSummary(double summary) {
        this.summary = summary;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }


}
