package com.bs.servicetransrecord.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TransRecordEntity {

    String cardId;
    String oppositeCardId;
    Timestamp time;
    String inOrOut;
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

    public Date getsettlementDate() {
        return settlementDate;
    }

    public void setsettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

}
