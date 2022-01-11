package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

public class FirstProgram {

    public static void main(String[] args) {
        Multi.createFrom()
                .items(1, 2, 3, 4, 5)
                .onItem().transform(i -> i * 2)
                .select().first(3)
                .subscribe()
                .with(value ->  System.out.println(value));
    }
}

