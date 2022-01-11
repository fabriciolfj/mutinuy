package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

public class FailMulti {

    public static void main(String[] args) {
        Multi.createFrom().failure(() -> new Exception("Error"))
                .subscribe()
                .with(value -> System.out.println(value),
                        failure -> System.out.println(failure),
                        () -> System.out.println("complete"));
    }
}
