package com.fabriciolfj.github.observing;

import io.smallrye.mutiny.Multi;

public class MethodHandleTypeEvents {

    public static void main(String[] args) {
        Multi.createFrom()
                .items(1,2,3,4)
                .onSubscription().invoke(() -> System.out.println("Se inscreveu"))
                .onItem().invoke(i -> System.out.println("Item recebido : " + i))
                .onFailure().invoke(f -> System.out.println("Falha " + f))
                .onCompletion().invoke(() -> System.out.println("Completou"))
                .onCancellation().invoke(() -> System.out.println("Cancelou"))
                .subscribe()
                .with(item -> System.out.println(item));
    }
}
