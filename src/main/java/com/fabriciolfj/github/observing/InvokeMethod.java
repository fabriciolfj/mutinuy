package com.fabriciolfj.github.observing;

import io.smallrye.mutiny.Multi;

public class InvokeMethod {

    //invoke e sincrono
    //indicado para logs
    public static void main(String[] args) {
        Multi.createFrom()
                .items(1,2,3,4)
                .invoke(i -> System.out.println("Item recebido " + i))
                .subscribe()
                .with(value -> System.out.println("Item consumido " + value));
    }
}
