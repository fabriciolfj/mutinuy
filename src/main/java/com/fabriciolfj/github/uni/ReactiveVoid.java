package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

public class ReactiveVoid {

    public static void main(String[] args) {
        Uni.createFrom().nullItem()
                .subscribe()
                .with(value -> System.out.println("Acabou " + value));
    }
}
