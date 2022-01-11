package com.fabriciolfj.github.observing;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class CallMethod {

    //é assincrono e indicado para fechar recursos
    public static void main(String[] args) {
        Multi.createFrom()
                .items(1,2,3,4)
                .onItem().call(i -> Uni.createFrom().voidItem()
                        .onItem().delayIt().by(Duration.ofSeconds(1) ))
                .subscribe()
                .with(value -> System.out.println(value));
    }
}
