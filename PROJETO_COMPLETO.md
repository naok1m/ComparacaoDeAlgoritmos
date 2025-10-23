# Sistema de Comparação de Algoritmos - Projeto Completo

## 🎓 Informações do Projeto

**Disciplina**: Algoritmos  
**Avaliação**: AV2  
**Tipo**: Projeto de análise comparativa de algoritmos de ordenação  
**Linguagem**: Java  
**Paradigma**: Programação Orientada a Objetos (POO)

---

## 📋 Objetivos do Projeto

### Objetivo Geral
Projetar e implementar um sistema modular em Java para comparar, de forma teórica e experimental, os algoritmos Merge Sort, Heap Sort e Quick Sort.

### Objetivos Específicos
1. ✅ Implementar os três algoritmos com contadores de métricas
2. ✅ Gerar diferentes distribuições de dados (aleatória, quase ordenada, reversa, repetida)
3. ✅ Medir desempenho experimental (tempo, comparações, trocas)
4. ✅ Realizar análise teórica de complexidade
5. ✅ Apresentar resultados em tabelas padronizadas
6. ✅ Fornecer análise comparativa e conclusões

---

## 🏗️ Arquitetura do Sistema

### Princípios de POO Aplicados

#### 1. **Encapsulamento**
- Cada classe tem responsabilidade única e bem definida
- Dados privados com métodos de acesso controlado
- Exemplos: `SortMetrics`, `BenchmarkResult`

#### 2. **Abstração**
- Interfaces definem contratos claros
- `SortAlgorithm`: abstração para algoritmos
- `DataGenerator`: abstração para geradores

#### 3. **Polimorfismo**
- Diferentes implementações da mesma interface
- Tratamento uniforme de algoritmos distintos
- Permite adicionar novos algoritmos facilmente

#### 4. **Modularidade**
- Separação em pacotes por funcionalidade
- Baixo acoplamento, alta coesão
- Fácil manutenção e extensão

---

## 📦 Estrutura de Pacotes

```
src/
│
├── 📁 model/                          # Modelo de dados
│   ├── SortMetrics.java              # Métricas de ordenação
│   └── BenchmarkResult.java          # Resultados agregados
│
├── 📁 algorithms/                     # Algoritmos de ordenação
│   ├── SortAlgorithm.java            # Interface base
│   ├── MergeSortAlgorithm.java       # Merge Sort
│   ├── HeapSortAlgorithm.java        # Heap Sort
│   └── QuickSortAlgorithm.java       # Quick Sort
│
├── 📁 generators/                     # Geradores de dados
│   ├── DataGenerator.java            # Interface base
│   ├── RandomDataGenerator.java      # Dados aleatórios
│   ├── NearlySortedDataGenerator.java # Quase ordenados
│   ├── ReverseDataGenerator.java     # Ordem reversa
│   └── RepeatedValuesDataGenerator.java # Valores repetidos
│
├── 📁 benchmark/                      # Sistema de benchmark
│   └── PerformanceBenchmark.java     # Medição de desempenho
│
├── 📁 analysis/                       # Análise e apresentação
│   ├── TableFormatter.java           # Formatação de tabelas
│   └── ResultAnalyzer.java           # Análise de resultados
│
├── 📁 examples/                       # Exemplos de uso
│   └── QuickDemo.java                # Demonstração rápida
│
└── Main.java                          # Programa principal
```

---

## 🔧 Componentes Principais

### 1. Model (Modelo de Dados)

#### SortMetrics
```java
- long comparisons      // Número de comparações
- long swaps            // Número de trocas
- long executionTime    // Tempo de execução
+ incrementComparisons()
+ incrementSwaps()
+ getExecutionTimeMillis()
```

#### BenchmarkResult
```java
- String algorithmName
- String dataDistribution
- int arraySize
- double avgComparisons
- double avgSwaps
- double avgTimeMillis
- double stdDevTime
+ setAverages()
+ setTimeStatistics()
```

### 2. Algorithms (Algoritmos)

#### SortAlgorithm (Interface)
```java
+ SortMetrics sort(int[] array)
+ String getName()
+ String getBestCaseComplexity()
+ String getAverageCaseComplexity()
+ String getWorstCaseComplexity()
+ boolean isStable()
```

#### Implementações
- **MergeSortAlgorithm**: Dividir e conquistar, estável
- **HeapSortAlgorithm**: Baseado em heap, in-place
- **QuickSortAlgorithm**: Particionamento, múltiplas estratégias de pivô

### 3. Generators (Geradores)

#### DataGenerator (Interface)
```java
+ int[] generate(int size)
+ String getDistributionName()
+ String getDescription()
```

#### Implementações
- **RandomDataGenerator**: Distribuição uniforme
- **NearlySortedDataGenerator**: 10% de perturbação
- **ReverseDataGenerator**: Ordem decrescente
- **RepeatedValuesDataGenerator**: Poucos valores distintos

### 4. Benchmark

#### PerformanceBenchmark
```java
- int repetitions
+ runBenchmark(algorithm, generator, size)
+ runCompleteBenchmark(algorithms, generators, sizes)
- calculateStatistics()
- isSorted()
```

### 5. Analysis (Análise)

#### TableFormatter
```java
+ printAllResults()
+ printResultsByDistribution()
+ printResultsByAlgorithm()
+ printComparisonBySize()
+ printTimeSummary()
```

#### ResultAnalyzer
```java
+ printTheoreticalAnalysis()
+ printBehaviorObservations()
+ printBestPerformers()
- analyzeMergeSort()
- analyzeHeapSort()
- analyzeQuickSort()
```

---

## 🎯 Funcionalidades Implementadas

### ✅ Geração de Dados
- [x] Distribuição aleatória uniforme
- [x] Distribuição quase ordenada (10% perturbação)
- [x] Distribuição reversa (decrescente)
- [x] Distribuição com valores repetidos

### ✅ Algoritmos de Ordenação
- [x] Merge Sort (estável, O(n log n))
- [x] Heap Sort (in-place, O(n log n))
- [x] Quick Sort com pivô no final
- [x] Quick Sort com mediana de três

### ✅ Medição de Métricas
- [x] Contagem de comparações
- [x] Contagem de trocas/movimentos
- [x] Tempo de execução (nanosegundos)
- [x] Validação de ordenação correta

### ✅ Análise Estatística
- [x] Média de múltiplas execuções
- [x] Desvio padrão
- [x] Valores mínimo e máximo

### ✅ Apresentação de Resultados
- [x] Tabelas consolidadas
- [x] Tabelas por distribuição
- [x] Tabelas por algoritmo
- [x] Comparação por tamanho
- [x] Resumo de tempos
- [x] Melhores desempenhos

### ✅ Análise Teórica
- [x] Complexidades assintóticas
- [x] Estabilidade dos algoritmos
- [x] Uso de memória
- [x] Observações comportamentais

---

## 📊 Configurações Padrão

```java
// Tamanhos de array testados
int[] ARRAY_SIZES = {1000, 10000, 50000, 100000};

// Repetições por cenário
int REPETITIONS = 5;

// Total de testes
Total = 4 algoritmos × 4 distribuições × 4 tamanhos × 5 repetições
      = 320 execuções

// Tempo estimado
2-5 minutos (depende do hardware)
```

---

## 🚀 Como Usar

### Execução Básica
```bash
# Compilar
compile.bat  # Windows
./compile.sh # Linux/Mac

# Executar benchmark completo
run.bat      # Windows
./run.sh     # Linux/Mac

# Demonstração rápida
run-demo.bat  # Windows
./run-demo.sh # Linux/Mac
```

### Uso Programático
```java
// Criar algoritmo
SortAlgorithm algo = new MergeSortAlgorithm();

// Gerar dados
DataGenerator gen = new RandomDataGenerator();
int[] data = gen.generate(10000);

// Ordenar e obter métricas
SortMetrics metrics = algo.sort(data);

// Exibir resultados
System.out.println("Comparações: " + metrics.getComparisons());
System.out.println("Tempo: " + metrics.getExecutionTimeMillis() + " ms");
```

---

## 📈 Resultados Esperados

### Dados Aleatórios
- **Quick Sort**: Geralmente o mais rápido
- **Heap Sort**: Desempenho intermediário
- **Merge Sort**: Mais lento, mas consistente

### Dados Quase Ordenados
- **Quick Sort** (mediana): Bom desempenho
- **Merge Sort**: Consistente
- **Heap Sort**: Sem mudança significativa

### Dados Reversos
- **Quick Sort** (último pivô): ⚠️ **MUITO LENTO** (O(n²))
- **Quick Sort** (mediana): Melhor
- **Heap Sort**: Melhor opção
- **Merge Sort**: Consistente

### Dados com Repetições
- **Quick Sort**: Rápido
- **Merge Sort**: Preserva ordem (estável)
- **Heap Sort**: Bom desempenho

---

## 🎓 Valor Acadêmico

### Conceitos Demonstrados

1. **Análise de Algoritmos**
   - Complexidade de tempo
   - Complexidade de espaço
   - Análise assintótica

2. **Programação Orientada a Objetos**
   - Interfaces e polimorfismo
   - Encapsulamento
   - Modularidade

3. **Estruturas de Dados**
   - Arrays
   - Heaps (árvore binária implícita)
   - Recursão

4. **Metodologia Científica**
   - Hipótese teórica
   - Experimentação
   - Análise de resultados
   - Conclusões

5. **Engenharia de Software**
   - Código limpo
   - Documentação
   - Testabilidade
   - Extensibilidade

---

## 📚 Documentação Completa

O projeto inclui documentação abrangente:

| Documento | Descrição |
|-----------|-----------|
| `README.md` | Visão geral do projeto |
| `INSTALACAO.md` | Guia de instalação e configuração |
| `USAGE.md` | Exemplos de uso e customização |
| `ANALISE_TEORICA.md` | Análise teórica detalhada dos algoritmos |
| `EXEMPLO_SAIDA.md` | Exemplos de saída do programa |
| `PROJETO_COMPLETO.md` | Este documento - visão completa |

---

## 🔄 Extensibilidade

### Adicionar Novo Algoritmo

1. Criar classe implementando `SortAlgorithm`
2. Implementar método `sort()` com contadores
3. Adicionar em `Main.initializeAlgorithms()`

Exemplo:
```java
public class InsertionSortAlgorithm implements SortAlgorithm {
    public SortMetrics sort(int[] array) {
        // Implementação com métricas
    }
    // ... outros métodos
}
```

### Adicionar Nova Distribuição

1. Criar classe implementando `DataGenerator`
2. Implementar método `generate()`
3. Adicionar em `Main.initializeGenerators()`

Exemplo:
```java
public class GaussianDataGenerator implements DataGenerator {
    public int[] generate(int size) {
        // Implementação com distribuição Gaussiana
    }
    // ... outros métodos
}
```

---

## ✅ Checklist de Entrega

### Implementação
- [x] Merge Sort funcional com métricas
- [x] Heap Sort funcional com métricas
- [x] Quick Sort funcional com métricas
- [x] Geradores de dados funcionais
- [x] Sistema de benchmark completo
- [x] Análise e formatação de resultados

### Documentação
- [x] README.md com descrição do projeto
- [x] Comentários no código
- [x] Análise teórica documentada
- [x] Guia de instalação
- [x] Guia de uso
- [x] Exemplos de saída

### Testes
- [x] Compilação sem erros
- [x] Execução sem exceções
- [x] Validação de ordenação correta
- [x] Métricas coletadas corretamente

### Análise
- [x] Complexidades teóricas documentadas
- [x] Resultados experimentais coletados
- [x] Tabelas formatadas
- [x] Observações comportamentais
- [x] Conclusões e recomendações

---

## 🏆 Diferenciais do Projeto

1. **Modularidade Completa**: Estrutura profissional em pacotes
2. **Extensibilidade**: Fácil adicionar novos algoritmos/distribuições
3. **Documentação Rica**: 6 arquivos de documentação
4. **Scripts de Automação**: Compilação e execução simplificadas
5. **Múltiplas Estratégias**: Quick Sort com diferentes pivôs
6. **Análise Estatística**: Média, desvio padrão, min/max
7. **Validação Automática**: Verifica se ordenação está correta
8. **Apresentação Profissional**: Tabelas formatadas e análises detalhadas

---

## 💡 Aprendizados e Insights

### Teóricos
- O(n log n) é ótimo para ordenação por comparação
- Constantes multiplicativas importam na prática
- Trade-offs entre tempo, espaço e estabilidade

### Práticos
- Quick Sort é rápido mas sensível ao pivô
- Cache locality afeta performance real
- Mediana de três melhora muito o Quick Sort
- Heap Sort é subestimado (bom para memória limitada)

### Engenharia
- POO facilita extensibilidade
- Separação de responsabilidades melhora manutenção
- Documentação é essencial
- Testes validam implementação

---

## 📞 Suporte e Manutenção

### Problemas Comuns
1. **Encoding errors**: Use `-encoding UTF-8`
2. **OutOfMemory**: Reduza tamanhos ou aumente heap
3. **Lentidão**: Reduza repetições ou tamanhos

### Melhorias Futuras
- [ ] Visualização gráfica dos resultados
- [ ] Exportação para CSV/Excel
- [ ] Mais algoritmos (Insertion, Shell, Tim Sort)
- [ ] Interface gráfica
- [ ] Análise de cache misses
- [ ] Paralelização

---

## 🎯 Conclusão

Este projeto demonstra:
- ✅ Domínio de algoritmos de ordenação
- ✅ Aplicação de POO em Java
- ✅ Capacidade de análise teórica e prática
- ✅ Habilidades de documentação e apresentação
- ✅ Pensamento crítico sobre trade-offs

**Sistema completo, modular, bem documentado e pronto para uso acadêmico e profissional!**

---

**Data de Conclusão**: Outubro 2025  
**Versão**: 1.0  
**Status**: ✅ Completo e Funcional

