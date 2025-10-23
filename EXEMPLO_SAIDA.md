# Exemplo de Saída do Sistema

Este documento mostra exemplos da saída gerada pelo sistema.

## 1. Mensagem de Boas-Vindas

```
╔══════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                  ║
║                    SISTEMA DE COMPARAÇÃO DE ALGORITMOS DE ORDENAÇÃO                             ║
║                                                                                                  ║
║                            Merge Sort | Heap Sort | Quick Sort                                  ║
║                                                                                                  ║
╚══════════════════════════════════════════════════════════════════════════════════════════════════╝

Este sistema realiza uma análise comparativa detalhada de algoritmos de ordenação,
medindo desempenho em diferentes cenários e distribuições de dados.

Configurações:
  • Tamanhos de array: 1,000, 10,000, 50,000, 100,000
  • Repetições por cenário: 5
  • Distribuições: Aleatória, Quase Ordenada, Reversa, Valores Repetidos
```

## 2. Análise Teórica de Complexidade

```
====================================================================================================
ANÁLISE TEÓRICA DE COMPLEXIDADE
====================================================================================================
Algoritmo                      Melhor Caso     Caso Médio      Pior Caso       Estável   
----------------------------------------------------------------------------------------------------
Merge Sort                     O(n log n)      O(n log n)      O(n log n)      Sim       
Heap Sort                      O(n log n)      O(n log n)      O(n log n)      Não       
Quick Sort (last)              O(n log n)      O(n log n)      O(n²)           Não       
Quick Sort (median of three)   O(n log n)      O(n log n)      O(n²)           Não       
====================================================================================================
```

## 3. Execução do Benchmark

```
================================================================================
INICIANDO BENCHMARK DE ALGORITMOS DE ORDENAÇÃO
================================================================================
Repetições por cenário: 5
Tamanhos de array: [1000, 10000, 50000, 100000]
================================================================================

>>> Distribuição: Aleatória (Distribuição uniforme aleatória)

  Tamanho do array: 1000
  [1/64] Executando Merge Sort com Aleatória (n=1000)...
  [2/64] Executando Heap Sort com Aleatória (n=1000)...
  [3/64] Executando Quick Sort (last) com Aleatória (n=1000)...
  [4/64] Executando Quick Sort (median of three) com Aleatória (n=1000)...
  
  Tamanho do array: 10000
  [5/64] Executando Merge Sort com Aleatória (n=10000)...
  ...
```

## 4. Tabela Consolidada de Resultados

```
============================================================================================================================================
TABELA CONSOLIDADA DE TODOS OS RESULTADOS
============================================================================================================================================
Algoritmo                 Distribuição         Tamanho    Comparações         Trocas   Tempo (ms) Desvio (ms)       Reps
--------------------------------------------------------------------------------------------------------------------------------------------
Merge Sort                Aleatória              1,000           8,724         11,988        0.234        0.045          5
Merge Sort                Aleatória             10,000         120,459        133,616        2.345        0.123          5
Merge Sort                Aleatória             50,000         786,432        851,968       14.567        0.456          5
Merge Sort                Aleatória            100,000       1,664,608      1,816,576       31.234        0.678          5
Heap Sort                 Aleatória              1,000           9,856          5,432        0.198        0.034          5
Heap Sort                 Aleatória             10,000         145,632         67,845        1.987        0.098          5
Heap Sort                 Aleatória             50,000         945,678        456,789       12.345        0.345          5
Heap Sort                 Aleatória            100,000       2,012,345        987,654       27.890        0.567          5
Quick Sort (last)         Aleatória              1,000           7,234          4,567        0.156        0.023          5
Quick Sort (last)         Aleatória             10,000         98,765         54,321        1.678        0.089          5
Quick Sort (last)         Aleatória             50,000         678,901        345,678       10.234        0.234          5
Quick Sort (last)         Aleatória            100,000       1,456,789        723,456       22.345        0.456          5
...
============================================================================================================================================
```

## 5. Resultados por Distribuição

```
============================================================================================================================================
RESULTADOS: ALEATÓRIA
============================================================================================================================================
Algoritmo                 Distribuição         Tamanho    Comparações         Trocas   Tempo (ms) Desvio (ms)       Reps
--------------------------------------------------------------------------------------------------------------------------------------------
Merge Sort                Aleatória              1,000           8,724         11,988        0.234        0.045          5
Merge Sort                Aleatória             10,000         120,459        133,616        2.345        0.123          5
Merge Sort                Aleatória             50,000         786,432        851,968       14.567        0.456          5
Merge Sort                Aleatória            100,000       1,664,608      1,816,576       31.234        0.678          5
...
============================================================================================================================================
```

## 6. Resumo de Tempos

```
====================================================================================================
RESUMO DE TEMPOS DE EXECUÇÃO (ms)
====================================================================================================
Algoritmo                         n=1,000        n=10,000        n=50,000       n=100,000
----------------------------------------------------------------------------------------------------
Merge Sort                          0.234           2.345          14.567          31.234
Heap Sort                           0.198           1.987          12.345          27.890
Quick Sort (last)                   0.156           1.678          10.234          22.345
Quick Sort (median of three)        0.167           1.789          10.567          23.456
====================================================================================================
```

## 7. Comparação por Tamanho

```
============================================================================================================================================
COMPARAÇÃO PARA TAMANHO n = 10,000
============================================================================================================================================
Algoritmo                 Distribuição         Tamanho    Comparações         Trocas   Tempo (ms) Desvio (ms)       Reps
--------------------------------------------------------------------------------------------------------------------------------------------
Merge Sort                Aleatória             10,000         120,459        133,616        2.345        0.123          5
Merge Sort                Quase Ordenada        10,000         120,459        133,616        2.234        0.112          5
Merge Sort                Reversa               10,000         120,459        133,616        2.267        0.098          5
Merge Sort                Valores Repetidos     10,000         120,459        133,616        2.198        0.087          5
Heap Sort                 Aleatória             10,000         145,632         67,845        1.987        0.098          5
...
============================================================================================================================================
```

## 8. Melhores Desempenhos

```
====================================================================================================
MELHORES DESEMPENHOS POR CENÁRIO
====================================================================================================

>>> Aleatória:
  n=      1,000: Quick Sort (last)                (0.156 ms)
  n=     10,000: Quick Sort (last)                (1.678 ms)
  n=     50,000: Quick Sort (last)                (10.234 ms)
  n=    100,000: Quick Sort (last)                (22.345 ms)

>>> Quase Ordenada:
  n=      1,000: Quick Sort (median of three)     (0.145 ms)
  n=     10,000: Quick Sort (median of three)     (1.567 ms)
  n=     50,000: Quick Sort (median of three)     (9.876 ms)
  n=    100,000: Quick Sort (median of three)     (21.234 ms)

>>> Reversa:
  n=      1,000: Heap Sort                        (0.198 ms)
  n=     10,000: Heap Sort                        (1.987 ms)
  n=     50,000: Heap Sort                        (12.345 ms)
  n=    100,000: Heap Sort                        (27.890 ms)

>>> Valores Repetidos:
  n=      1,000: Quick Sort (last)                (0.134 ms)
  n=     10,000: Quick Sort (last)                (1.456 ms)
  n=     50,000: Quick Sort (last)                (9.123 ms)
  n=    100,000: Quick Sort (last)                (19.876 ms)

====================================================================================================
```

## 9. Observações e Análise Comportamental

```
====================================================================================================
OBSERVAÇÕES E ANÁLISE COMPORTAMENTAL
====================================================================================================

>>> MERGE SORT:
  • Complexidade consistente O(n log n) em todos os casos
  • Desempenho previsível independente da distribuição
  • Maior número de movimentos devido às cópias para arrays auxiliares
  • Estável: mantém ordem relativa de elementos iguais
  • Uso adicional de memória O(n)
  • Variação de tempo: Aleatória vs Reversa = 1.42%

>>> HEAP SORT:
  • Complexidade O(n log n) garantida em todos os casos
  • Ordenação in-place: O(1) de memória adicional
  • Não estável: pode alterar ordem de elementos iguais
  • Menor número de comparações que Merge Sort em muitos casos
  • Padrão de acesso à memória menos favorável ao cache
  • Trocas em relação ao Merge Sort: 51.23%

>>> QUICK SORT:
  • Caso médio O(n log n), pior caso O(n²)
  • Desempenho fortemente dependente da escolha do pivô
  • Geralmente o mais rápido na prática para dados aleatórios
  • Não estável na implementação padrão
  • Ordenação in-place com O(log n) de memória para recursão
  • Performance degradada em ordem reversa: 4.32x mais lento

>>> ANÁLISE POR DISTRIBUIÇÃO:

  • ALEATÓRIA:
    - Caso médio para todos os algoritmos
    - Quick Sort geralmente mais rápido

  • QUASE ORDENADA:
    - Merge Sort mantém desempenho consistente
    - Quick Sort pode ter bom desempenho dependendo do pivô

  • REVERSA:
    - Pior caso para Quick Sort com pivô no final
    - Merge Sort e Heap Sort mantêm O(n log n)

  • VALORES REPETIDOS:
    - Muitas comparações com resultados iguais
    - Merge Sort (estável) preserva ordem original de elementos iguais

====================================================================================================
```

## 10. Conclusões

```
╔══════════════════════════════════════════════════════════════════════════════════════════════════╗
║                                                                                                  ║
║                              ANÁLISE CONCLUÍDA COM SUCESSO                                       ║
║                                                                                                  ║
╚══════════════════════════════════════════════════════════════════════════════════════════════════╝

CONCLUSÕES PRINCIPAIS:

1. MERGE SORT:
   ✓ Desempenho consistente e previsível
   ✓ Ideal quando estabilidade é necessária
   ✗ Uso adicional de memória

2. HEAP SORT:
   ✓ Garantia de O(n log n) em todos os casos
   ✓ Ordenação in-place
   ✗ Não estável

3. QUICK SORT:
   ✓ Geralmente o mais rápido na prática
   ✓ Ordenação in-place
   ✗ Desempenho dependente da escolha do pivô
   ✗ Pior caso O(n²) se o pivô for mal escolhido

RECOMENDAÇÕES:
• Use Merge Sort quando precisar de estabilidade e desempenho garantido
• Use Heap Sort quando memória for limitada e estabilidade não for necessária
• Use Quick Sort (com mediana de três) para melhor desempenho médio
```

## Observações

**Nota**: Os valores numéricos acima são exemplos ilustrativos. Os valores reais variarão dependendo:
- Do hardware utilizado
- Da JVM e suas otimizações
- Do estado do sistema durante a execução
- Da implementação específica dos algoritmos

**Tempo de Execução**: O benchmark completo com as configurações padrão leva aproximadamente 2-5 minutos.

**Precisão**: Devido à natureza estocástica das distribuições aleatórias e à variabilidade do sistema, é normal observar pequenas variações entre execuções diferentes.

