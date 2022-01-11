package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

public class MutiEmpty {

    public static void main(String[] args) {
        Multi.createFrom().empty()
                .subscribe()
                .with(value -> System.out.println(value));
    }
}
