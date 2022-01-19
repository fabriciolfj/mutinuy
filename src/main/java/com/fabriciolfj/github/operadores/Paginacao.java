package com.fabriciolfj.github.operadores;

import io.smallrye.mutiny.Multi;

import java.util.concurrent.atomic.AtomicInteger;

public class Paginacao {

    public static void main(String[] args) {
        ExamploPaginacao api = new ExamploPaginacao();

        Multi.createBy()
                .repeating() //vai repedindo a iteracao
                .completionStage(
                        () -> new AtomicInteger(),
                        stage -> api.getPage(stage.getAndIncrement()))
                .atMost(2)//impoe o numero maximo de iterações
                //.until(list -> list.isEmpty()) //condicao de parada, nao manda para o downstream o valor que nao passou na condição
                //.whilst(list -> list.isEmpty()) //passa o valor que nao passou na condicao e interrompe o stream
                .onItem()
                .disjoint() //junta os valores
                .subscribe()
                .with(System.out::println);
    }
}
