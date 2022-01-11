package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

public class SecondProgram {

    public static void main(String[] args) {
        Multi.createFrom()
                .items(1, 2, 3)
                .onItem().transform(i -> i + 2)
                .subscribe()
                .with(value -> System.out.println(value),
                        failure -> System.out.println("Error " + failure),
                        () -> System.out.println("Complete"));
    }
}
