package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class FiltrandoMulti {

    public static void main(String[] args) {
        assincrono();
    }

    private static void sincrono() {
        Multi.createFrom()
                .items(1, 2, 3, 4, 5)
                .select()
                .where(v -> v % 2 == 0)
                .collect()
                .asList()
                .subscribe()
                .with(System.out::println);
    }

    private static void assincrono() {
        Multi.createFrom()
                .items(1, 2, 3, 4, 5, 6)
                .select()
                .when(v -> Uni.createFrom().item(v % 2 == 0))
                .collect()
                .asList()
                .subscribe()
                .with(System.out::println);
    }
}
