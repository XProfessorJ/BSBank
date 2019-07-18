package com.bs.servicetransrecord.utils;

import java.util.ArrayList;
import java.util.List;

public class PageList {
    private int page;   //当前页
    private int totalRows;   //总行数
    private int pages;    //总页数
    private List list=new ArrayList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public PageList() {
    }

    public PageList(int page, int totalRows, int pages, List list) {
        this.page = page;
        this.totalRows = totalRows;
        this.pages = pages;
        this.list = list;
    }

    public List getList() {
        if(list==null){
            list=new ArrayList();
        }
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}
