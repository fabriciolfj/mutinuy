package com.fabriciolfj.github.integracao;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UniMultiComCompletionStage {

    private static final Executor EXECUTOR = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        uni();
        multi();
    }

    private static void multi() {
        Multi.createFrom().completionStage(() -> CompletableFuture.supplyAsync(() ->"Fabricio", EXECUTOR))
                .onItem()
                .transform(v -> v.toUpperCase())
                .subscribe()
                .with(System.out::println);

    }

    private static void uni() {
        Uni.createFrom().completionStage(() -> CompletableFuture.supplyAsync(() -> "Fabricio", EXECUTOR))
                .onItem().transform(v -> v.toUpperCase())
                .subscribe()
                .with(System.out::println);
    }
}
