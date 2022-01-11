package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

import java.util.concurrent.atomic.AtomicInteger;

public class FourProgram {

    public static void main(String[] args) {
        var atomic = new AtomicInteger();
        var uni = Uni.createFrom().item(() -> atomic.getAndIncrement());

        uni.subscribe().with(value -> System.out.println(value));
        uni.subscribe().with(value -> System.out.println(value));
        uni.subscribe().with(value -> System.out.println(value));
    }
}
