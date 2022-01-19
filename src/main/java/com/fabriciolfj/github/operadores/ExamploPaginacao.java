package com.fabriciolfj.github.operadores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ExamploPaginacao {

    private List<String> nomes1 = Arrays.asList("Fabricio", "Lucas");
    private List<String> nomes2 = Arrays.asList("Fabiola", "Roberto");
    private List<String> nomes3 = Arrays.asList("Fabio", "Carlos");
    private List<String> nomes4 = Arrays.asList("Xuxa", "Cassiano");

    private Map<Integer, List<String>> paginacao = new HashMap<>();

    public ExamploPaginacao() {
        this.paginacao.put(1, nomes1);
        this.paginacao.put(2, nomes2);
        this.paginacao.put(3, nomes3);
        this.paginacao.put(4, nomes4);
    }

    public CompletionStage<List<String>> getPage(final Integer num) {
        return CompletableFuture.supplyAsync(() -> paginacao.get(num));
    }
}
