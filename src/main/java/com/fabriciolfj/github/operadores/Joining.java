package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.UniJoin;

import java.util.List;

public class Joining {

    final static Uni<Integer> a = Uni.createFrom().item(1);
    final static Uni<Integer> b = Uni.createFrom().item(2);
    final static Uni<Integer> c = Uni.createFrom().item(3);

    public static void main(String[] args) {
        //juntando();
        //pegarOPrimeiroQueTerminar();
        //pegarOPrimeiroQueEmitirOEvento();
        builder();
    }

    private static void builder() {
        UniJoin.Builder<Integer> builder = Uni.join().builder();
        int index = 0;

        while(index < 10) {
           Uni<Integer> uni = Uni.createFrom().item(index);
           builder.add(uni);
           index++;
        }

        builder.joinAll().andFailFast()
                .subscribe()
                .with(System.out::println);
    }

    private static void pegarOPrimeiroQueEmitirOEvento() {
        Uni<Integer> res = Uni.join().first(a, b, c).withItem();
        res.subscribe().with(System.out::println);
    }

    private static void pegarOPrimeiroQueTerminar() {
        Uni<Integer> res = Uni.join().first(a, b, c).toTerminate();
        res.subscribe().with(System.out::println);
    }

    private static void juntando() {
        Uni<List<Integer>> res = Uni.join().all(a, b, c).andCollectFailures();

        res.subscribe().with(i -> System.out.println(i));

        // caso algum dele falhe, vc quer que falhe rapido
        Uni<List<Integer>> fast = Uni.join().all(a, b, c).andFailFast();
    }
}
