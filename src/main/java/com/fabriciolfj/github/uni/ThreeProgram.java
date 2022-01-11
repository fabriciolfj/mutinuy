package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

public class ThreeProgram {

    public static void main(String[] args) {
        Uni.createFrom()
                .item("hello")
                .subscribe()
                .with(item ->
                        System.out.println(item),
                        failure -> System.out.println("Failed with " + failure)
                );
    }
}
