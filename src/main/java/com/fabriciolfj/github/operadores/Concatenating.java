package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class Concatenating {

    //mantem a ordem dos eventos, primeiro ele conclui, dp vai para o segundo e assim por diante
    public static void main(String[] args) {
        Multi<String> first = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 1 - " + i);

        Multi<String> second = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 2 - " + i);

        Multi<String> third = Multi.createFrom().ticks().every(Duration.ofMillis(10))
                .onItem().transform(i -> "Stream 3 - " + i);

        Multi.createBy()
                .concatenating()
                .streams(first, second, third)
                .subscribe()
                .with(System.out::println);
    }
}
