package com.fabriciolfj.github.integracao;


import io.smallrye.mutiny.operators.multi.processors.UnicastProcessor;

/*
* O UnicastProcessor é uma implementação do Multi que permite enfileirar itens em uma fila.
* Os itens são então despachados para o assinante usando o protocolo de solicitação.
*  Embora esse padrão seja contra a ideia de contrapressão, ele permite conectar fontes de dados que não suportam contrapressão com seu assinante.
* */
public class UnicastProcessorExemplo {

    public static void main(String[] args) throws InterruptedException {
        UnicastProcessor<String> processo = UnicastProcessor.create();
        processo.onItem().transform(v -> v.toUpperCase())
                .onFailure().recoverWithItem("Error");

        new Thread(() -> {
            for (int i = 0; i < 1000; i ++) {
                processo.onNext(Integer.toString(i));
            }

            processo.onComplete();
        }).start();

        Thread.sleep(1000);

        processo.subscribe().with(System.out::println);
    }
}
