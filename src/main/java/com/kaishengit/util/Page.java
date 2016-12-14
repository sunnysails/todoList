package com.kaishengit.util;

import java.util.List;

/**
 * Created by sunny on 2016/12/1.
 */
public class Page<T> {
//    总页数
    private int totalPage;
//    当前页码
    private int pageNo;
//    当前页数据
    private List<T> items;
//    总条数
    private int total;
//    每页显示的数据量
    private int pageSize;
//    当前页的起始行号
    private int stat;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
