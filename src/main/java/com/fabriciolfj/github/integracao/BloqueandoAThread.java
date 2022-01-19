package com.fabriciolfj.github.integracao;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class BloqueandoAThread {

    public static void main(String[] args) {
        //utilizandoAwait();
        iterandoMulti();
    }

    private static void iterandoMulti() {
        Iterable<String> values = Multi.createFrom().items("fabricio", "lucas")
                .subscribe()
                .asIterable();

        values.forEach(System.out::println);
    }

    private static void utilizandoAwait() {
        final String result = Uni.createFrom()
                .item("fabricio")
                .await()
                        .atMost(Duration.ofMillis(100)); //se nao chegar o evento nesse tempo, dara um TimeOutException
                //.indefinitely();

        System.out.println(result);
    }
}
