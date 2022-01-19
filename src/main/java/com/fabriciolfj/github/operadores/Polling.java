package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Polling {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);

        Uni<Integer> pollItem = Uni.createFrom().item(RANDOM.nextInt())
                .runSubscriptionOn(executor); //o upstream assina em outra thread

        Multi<Integer> stream = pollItem.repeat().indefinitely();

        Cancellable cancellable = stream.subscribe().with(System.out::println);

       // cancellable.cancel();
    }
}
