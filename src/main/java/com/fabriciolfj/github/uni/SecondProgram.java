package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class SecondProgram {

    public static void main(String[] args) {
        Uni.createFrom()
                .item(1)
                .onItem().transform(i -> "hello-" + i)
                .onItem().delayIt().by(Duration.ofMillis(100))
                .subscribe().with(item -> System.out.println(item));
    }
}
