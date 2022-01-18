package com.fabriciolfj.github.commons;


public class Response {

    private String value;

    public Response(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Response{" +
                "value='" + value + '\'' +
                '}';
    }
}
