package com.fabriciolfj.github.operadores;

import com.fabriciolfj.github.commons.Response;
import io.smallrye.mutiny.Uni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CombinandoUni {

    public static void main(String[] args) {
        //useTuple();
        useCombine();
    }

    private static void useCombine() {
        Uni.combine()
                .all()
                .unis(invokeServiceA(), invokeServiceB())
                .combinedWith(value -> {
                    Map<String, Response> map = new HashMap<>();
                    map.put("1", (Response) value.get(0));
                    map.put("2", (Response) value.get(1));
                    return map;
                }).subscribe()
                .with(v -> System.out.println(v));
    }

    private static void useTuple() {
        Uni.combine()
                .all()
                .unis(invokeServiceA(), invokeServiceB())
                .asTuple()
                .subscribe()
                .with(tuple -> {
                    System.out.println(tuple.getItem1().getValue());
                    System.out.println(tuple.getItem2().getValue());
                });
    }

    private static Uni<Response> invokeServiceA() {
        return Uni.createFrom().item(new Response("Service A"));
    }

    private static Uni<Response> invokeServiceB() {
        return Uni.createFrom().item(new Response("Service B"));
    }
}
