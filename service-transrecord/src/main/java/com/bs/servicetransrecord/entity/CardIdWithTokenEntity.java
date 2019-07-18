package com.bs.servicetransrecord.entity;

public class CardIdWithTokenEntity {

    private String cardId;
    private String token;
    private int pagenum;
    private int pagerow;

    public int getTotalRows() {
        return totalRows;
    }

    public CardIdWithTokenEntity(String cardId, String token, int pagenum, int pagerow, int totalRows) {
        this.cardId = cardId;
        this.token = token;
        this.pagenum = pagenum;
        this.pagerow = pagerow;
        this.totalRows = totalRows;
    }

    public CardIdWithTokenEntity() {
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    private int totalRows;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagerow() {
        return pagerow;
    }

    public void setPagerow(int pagerow) {
        this.pagerow = pagerow;
    }

}
