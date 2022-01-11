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


## Upstream vs downstream
- Em programação reative sem nos deparamos com esses termos upstream e downstream, abaixo uma definição rapida de ambos:
  - upstream: dentro de uma pipeline reativa, seria a etapa onde há menos valor agregado ou logo no inicio (não possiu dependência de outro objeto ou componente).
  - downstream: dentro de uma pipeline reativa, seria o final onde há mais valor agregado ao objecto ou componente (possui depenência de outro objeto ou componente). 
