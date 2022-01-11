package com.fabriciolfj.github.uni;

import io.smallrye.mutiny.Uni;

public class FailProgram {

    public static void main(String[] args) {
        Uni.createFrom().failure(new Exception("teste"))
                .subscribe()
                .with(item -> System.out.println(item),
                        failure -> System.out.println(failure)
                );
    }
}
