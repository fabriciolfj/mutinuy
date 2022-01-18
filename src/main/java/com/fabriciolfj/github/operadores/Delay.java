package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class Delay {

    public static void main(String[] args) {
        //delayUni();
        delayMulti();
    }

    private static void delayUni() {
        Uni.createFrom().item("1")
                .onItem()
                .delayIt().by(Duration.ofMillis(100))
                .subscribe()
                .with(System.out::println);
    }

    private static void delayMulti() {
        Multi.createFrom().items(1,2,3,4)
                .onItem().call(i -> Uni.createFrom().item(i).onItem().delayIt().by(Duration.ofMillis(100)))
                .subscribe()
                .with(System.out::println);

    }
}
