package com.spring.boot.model;

import java.util.List;

public class TableModel <T> {
    private String[] headers;
    private String title;
    private List<T> data;

    public TableModel(String[] headers, String title, List<T> data) {
        this.headers = headers;
        this.title = title;
        this.data = data;
    }

    public String[] getHeaders() {
        return headers;
    }

    public String getTitle() {
        return title;
    }

    public List<T> getData() {
        return data;
    }
}
