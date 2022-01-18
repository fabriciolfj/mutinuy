package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Uni;

public class LidandoComValoresNulos {

    public static void main(String[] args) {
        Uni.createFrom().item( null)
                .onItem()
                .ifNull()
                //.switchTo(() -> Uni.createFrom().item("Hello"))
                .failWith(() -> new Exception("error"))
                .subscribe()
                .with(System.out::println);
    }
}
