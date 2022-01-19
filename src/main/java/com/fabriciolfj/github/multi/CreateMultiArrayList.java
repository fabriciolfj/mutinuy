package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

import java.util.Arrays;

public class CreateMultiArrayList {

    public static void main(String[] args) {
        Multi.createFrom()
                .items(Arrays.asList(1,2,3,4,5))
                .log()
                .subscribe()
                .with(value -> System.out.println(value));
    }
}
