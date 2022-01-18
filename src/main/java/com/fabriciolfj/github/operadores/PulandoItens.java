package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class PulandoItens {

    public static void main(String[] args) {
        //pulandoPrimeios3Itens();
        //pulandoUltimos3Itens();
        pulandoEmUmDeterminadoTempo();
    }

    private static void pulandoEmUmDeterminadoTempo() {
        invoke().skip().first(Duration.ofMillis(1))
                .subscribe()
                .with(System.out::println);
    }

    private static void pulandoUltimos3Itens() {
        invoke().skip().last(3)
                .subscribe()
                .with(System.out::println);
    }

    private static void pulandoPrimeios3Itens() {
        invoke().skip().first(3)
                .subscribe()
                .with(System.out::println);
    }

    private static Multi<Integer> invoke() {
        return Multi.createFrom().items(1, 2, 3, 4, 5, 6, 7);
    }
}
