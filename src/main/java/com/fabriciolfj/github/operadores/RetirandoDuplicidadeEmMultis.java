package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

public class RetirandoDuplicidadeEmMultis {

    public static void main(String[] args) {
        //distincts();
        repetitions();
    }

    //nao indicado para grans collections/eventos
    private static void distincts() {
        invoke().select()
                .distinct()
                .collect()
                .asList()
                .subscribe()
                .with(System.out::println);
    }

    //retira apenas o itens subsequentes repetidos
    private static void repetitions() {
        invoke()
                .skip()
                .repetitions()
                .collect()
                .asList()
                .subscribe()
                .with(System.out::println);
    }

    private static Multi<Integer> invoke() {
        return Multi.createFrom().items(1, 2, 2, 3,4,5,6,2,3,4,5,6, 9);
    }
}
