package com.fabriciolfj.github.handingfailures;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class HandingFailures {

    public static void main(String[] args) {
        //logandoFalhas();
        //transformandoEmOutraFalha();
        //recuperando(); //so vai receber o recover, mais nenhum item
        mudandoDeFluxo();
    }

    private static void mudandoDeFluxo() {
        Multi.createFrom().failure(() -> new RuntimeException("Error"))
                .onFailure().recoverWithMulti(() -> Multi.createFrom().items("Fabricio", "Lucas"))
                .subscribe()
                .with(e -> System.out.println("Item recebido " + e));
    }

    private static void recuperando() {
        final Uni<String> error = Uni.createFrom().failure(() -> new RuntimeException("error"));

        error.log().onFailure().recoverWithItem(() -> "Hello")
                .subscribe()
                .with(e -> System.out.println("Item recebido " + e));
    }

    private static void transformandoEmOutraFalha() {
        final Uni<String> error = Uni.createFrom().failure(() -> new Exception("Error"));

        error.onFailure().transform(e -> new RuntimeException(e.getMessage()))
                .subscribe()
                .with(i -> System.out.println("Item recebido " + i));
    }

    private static void logandoFalhas() {
        final Uni<String> error = Uni.createFrom().failure(() ->  new RuntimeException("Error"));

        error.onFailure().invoke(log -> System.out.println(log))
                .subscribe()
                .with(i -> System.out.println("Item recebido " + i));
    }
}
