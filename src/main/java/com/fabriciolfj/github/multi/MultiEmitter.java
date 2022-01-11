package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

public class MultiEmitter {

    public static void main(String[] args) {
        Multi.createFrom().emitter(em -> {
            System.out.println("Processando");
            em.emit(1);
            em.emit(2);
            em.emit(3);
            em.complete();
        }).subscribe()
                .with(value -> System.out.println(value));
    }
}
