package com.fabriciolfj.github.transforming;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class TransformingItems {

    public static void main(String[] args) {
        //uni();
        multi();
    }

    private static void multi() {
        Multi.createFrom()
                .items("Fabricio", "lucas")
                .onItem()
                .transform(i -> i.toUpperCase())
                .onItem()
                .transform(i -> i + "!")
                .subscribe()
                .with(i -> System.out.println(i));
    }

    private static void uni() {
        var uniString = Uni.createFrom().item("Hello");

        uniString.onItem().transform(i -> i.toUpperCase())
                .subscribe()
                .with(i -> System.out.println(i));
    }
}
