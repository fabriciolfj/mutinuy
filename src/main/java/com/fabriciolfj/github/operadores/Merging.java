package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class Merging {

    //nao garante a ordem dos fluxo
    public static void main(String[] args) {
        Multi<String> first = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 1 - " + i);

        Multi<String> second = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 2 - " + i);

        Multi<String> third = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 3 - " + i);

        Multi.createBy()
                .merging()
                .streams(first, second, third)
                .subscribe()
                .with(System.out::println);
    }
}
