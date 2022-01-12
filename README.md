# Mutiny

- Esse framework vem para concorrer com reactor e rxjava.
- Ele possui 2 operadores importantes, que são:
  - Uni -> emite um unico evento
  - Mult- -> emite vários eventos 
- Existem varios operadores para ambos e muitos comuns entre eles
- Podemos trabalhar com varios tipos de eventos, como:
  - item
  - falha
  - cancelamento
  - requisição
  - completo
- Existem grupos de operadores para lidar com cada etapa dita acima, alem de métodos espiões que não transformam o evento, apenas notifica você de algum

## Upstream vs downstream
- Em programação reative sem nos deparamos com esses termos upstream e downstream, abaixo uma definição rapida de ambos:
  - upstream: dentro de uma pipeline reativa, seria a etapa onde há menos valor agregado ou logo no inicio (não possiu dependência de outro objeto ou componente).
  - downstream: dentro de uma pipeline reativa, seria o final onde há mais valor agregado ao objecto ou componente (possui depenência de outro objeto ou componente). 

- Exemplificando em uma cadeia reativa:

```
Multi.createFrom()
.items(1,2,3,4) //upstream
.subscribe() //downstream
.with(item -> System.out.println(item));

```

## Transformação de items
- Ao transformar items em Multi<T>, podemos efetuar um merge (não garante a ordem) ou um concatenate (mantem a ordem dos eventos)

## Falhas
- Falhas são eventos terminais, ou seja, quando ocorre nenhum evento será recebido mais.
- Existem algumas estratégias para lidar com falhas, seja:
  - propagar
  - transformar em outra falha
  - recuperar, mudando para outro fluxo (mas não recebe mais itens, apos o recover)
  - tentar novamente
