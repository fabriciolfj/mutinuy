package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Uni;

import java.time.Duration;

public class TimeOutFallbackUni {

    public static void main(String[] args) {
        recuperar();
        falhar();
        customException();
    }

    private static void recuperar() {
        invoke()
                .ifNoItem().after(Duration.ofMillis(1))
                .recoverWithItem("Fallback")
                .subscribe()
                .with(System.out::println);
    }

    private static void falhar() {
        invoke().ifNoItem().after(Duration.ofMillis(1))
                .fail()
                .subscribe()
                .with(System.out::println);
    }

    private static void customException() {
        invoke().ifNoItem().after(Duration.ofMillis(1))
                .failWith(() -> new Exception("error"))
                .subscribe()
                .with(System.out::println);
    }

    private static Uni<String> invoke() {
        return Uni.createFrom().item("request");
    }
}
