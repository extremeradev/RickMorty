package com.app.rickmorty.model;

public class InfoModel {
    private Integer count;
    private Integer pages;
    private String next;
    private Object prev;

    public InfoModel(Integer count, Integer pages, String next, Object prev) {
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }


    public void setPrev(Object prev) {
        this.prev = prev;
    }


}
