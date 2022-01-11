package com.fabriciolfj.github.multi;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CreateMultSupplier {

    public static void main(String[] args) {
        var atomic = new AtomicInteger();
        Multi.createFrom()
                .items(() -> IntStream.range(atomic.getAndIncrement(), atomic.get() * 2).boxed())
                .subscribe()
                .with(value -> System.out.println(value));
    }
}
