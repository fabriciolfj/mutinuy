package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

public class EmitterProgram {

    public static void main(String[] args) {
        Uni.createFrom()
                .emitter(em -> {
                    System.out.println("Processando");
                    em.complete("Completo");
                }).subscribe().with(value -> System.out.println("Consumindo " + value));
    }
}
