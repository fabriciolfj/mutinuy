package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

public class CombinandoMulti {

    public static void main(String[] args) {
        Multi.createBy()
                .combining()
                .streams(invokeService1(), invokeService2())
                //.asTuple()
                .latestItems()
                .asTuple()
                .subscribe()
                .with(System.out::println);
    }

    private static Multi<String> invokeService1() {
        return Multi.createFrom().items("Fabricio", "Jacob");
    }

    private static Multi<String> invokeService2() {
        return Multi.createFrom().items("Suzana", "Penna");
    }
}
