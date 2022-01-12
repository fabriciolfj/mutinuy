package com.fabriciolfj.github.retrying;

import io.smallrye.mutiny.Multi;

import java.time.Duration;
import java.util.Random;

public class Retrying {

    private static Random random = new Random();

    public static void main(String[] args) {
        Multi.createFrom().items("Fabricio", "lucas")
                .onItem().transform(i -> i.toUpperCase())
                .onFailure()
                .retry()
                //.withBackOff(Duration.ofMillis(100), Duration.ofSeconds(1)) //atraso exponencial (inicial, maximo)
                //.atMost(3)
                .until(f -> isValid())
                .subscribe()
                .with(i -> System.out.println(i));
    }

    private static boolean isValid() {
        var value = random.nextInt();

        return value % 0 == 2 ? true : false;
    }
}
