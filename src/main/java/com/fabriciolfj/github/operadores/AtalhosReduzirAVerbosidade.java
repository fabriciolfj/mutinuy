package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

public class AtalhosReduzirAVerbosidade {

    public static void main(String[] args) {
        flatMapEquivaleAoTransform();
    }

    private static void flatMapEquivaleAoTransform() {
        invoke().flatMap(v -> Multi.createFrom().item(v.toUpperCase()))
                .subscribe()
                .with(System.out::println);
    }

    private static Multi<String> invoke() {
        return Multi.createFrom().items("Fabricio", "lucas");
    }
}
