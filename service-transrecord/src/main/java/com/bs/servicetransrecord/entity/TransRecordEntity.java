package com.bs.servicetransrecord.entity;

public class TransRecordEntity {

    String cardId;
    String oppositeCardId;
    String time;
    int inOrOut;
    double amount;
    double balance;
    String summary;
    String postscript;
    String settlementData;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(int inOrOut) {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public String getSettlementData() {
        return settlementData;
    }

    public void setSettlementData(String settlementData) {
        this.settlementData = settlementData;
    }

}
