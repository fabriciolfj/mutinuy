package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

public class Collecting {

    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        //consumindoMultiENoFinalEmitirUmUni();
        //collectMap();
        customCollect();
        String result = Optional.of(1).map(v -> test().apply(v)).get();
        System.out.println(result);
    }

    private static void customCollect() {
        Multi<String> multi = Multi.createFrom().items("Fabricio", "Lucas");
        Uni<MyCollection> uni = multi.collect().in(MyCollection::new, (col, item) -> col.add(item));

        uni.subscribe().with(i -> System.out.println(i.getData().size()));
    }

    private static Function<Integer, String> test() {
        return v -> "A" + v.toString();
    }

    private static void collectMap() {
        Multi<String> multi = Multi.createFrom().items("Fabricio", "Lucas");
        Uni<Map<Integer, String>> uni = multi.collect()
                .asMap(i -> getUniqueKey());

        uni.subscribe()
                .with(i -> System.out.println(i));
    }

    private static Integer getUniqueKey() {
        return RANDOM.nextInt();
    }

    private static void consumindoMultiENoFinalEmitirUmUni() {
        Multi<String> multi = Multi.createFrom().items("Fabricio", "Lucas");
        Uni<List<String>> uni =  multi.collect().asList();
        uni.subscribe().with(System.out::println);
    }
}
