package com.fabriciolfj.github.transforming;

import io.smallrye.mutiny.Multi;

public class TransformingTwoMulti {

    public static void main(String[] args) {
        merge();
        System.out.println("---------------------");
        concatenate();
    }

    private static void concatenate() {
        Multi.createFrom()
                .items("Fabricio", "Lucas")
                .onItem()
                .transformToMultiAndConcatenate(i -> invokeService(i))
                .subscribe()
                .with(i -> System.out.println(i));
    }

    private static void merge() {
        Multi.createFrom()
                .items("Fabricio", "Lucas")
                .onItem().transformToMultiAndMerge(name -> invokeService(name))
                .subscribe()
                .with(n ->  System.out.println(n));
    }

    private static Multi<String> invokeService(final String name) {
        return Multi.createFrom()
                .items(name + "!");
    }
}
