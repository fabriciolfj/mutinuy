package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MudandoDeThread {

    public static void main(String[] args) {
        final Executor executor = Executors.newFixedThreadPool(10);

        final String result =  Multi.createFrom().items("Fabricio", "Jacob")
                .emitOn(executor) //pega upstream e produz o downstream em outra thread
                .collect()
                .first()
                .await().indefinitely();

        System.out.println(result);

    }
}
