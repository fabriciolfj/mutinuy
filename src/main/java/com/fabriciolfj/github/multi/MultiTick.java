package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

import java.time.Duration;

public class MultiTick {


    public static void main(String[] args) {
        Multi.createFrom()
                .ticks()
                .every(Duration.ofMillis(1000))
                .subscribe()
                .with(value -> System.out.println(value));
    }
}
