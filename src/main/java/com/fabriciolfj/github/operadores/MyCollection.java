package com.fabriciolfj.github.operadores;

import java.util.ArrayList;
import java.util.List;

public class MyCollection {

    private List<String> data;

    public MyCollection() {
        this.data = new ArrayList<>();
    }

    public void add(final String value) {
        this.data.add(value);
    }

    public List<String> getData() {
        return data;
    }
}
