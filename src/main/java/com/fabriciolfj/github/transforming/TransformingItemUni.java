package com.fabriciolfj.github.transforming;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class TransformingItemUni {

    public static void main(String[] args) {
        //toUni();
        toMulti();
    }

    private static void toMulti() {
        Uni.createFrom()
                .item("Fabricio")
                .onItem()
                .transformToMulti(i -> Multi.createFrom().items(i, i))
                .subscribe()
                .with(i -> System.out.println(i));
    }

    private static void toUni() {
        Uni.createFrom().item("Fabricio")
                .onItem()
                .transformToUni(name -> invokeRemoteService(name))
                .subscribe()
                .with(i -> System.out.println(i), failure -> System.out.println(failure));
    }

    private static Uni<String> invokeRemoteService(final String name) {
        return Uni.createFrom().item("Hello " + name);
    }
}
