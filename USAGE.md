# Guia de Uso do Sistema de Comparação de Algoritmos

## 🚀 Início Rápido

### Executar o Benchmark Completo

```bash
cd src
javac Main.java
java Main
```

Isso executará uma análise completa com:
- 4 distribuições de dados
- 4 tamanhos diferentes (1.000 a 100.000 elementos)
- 4 algoritmos (Merge Sort, Heap Sort, Quick Sort com 2 estratégias de pivô)
- 5 repetições por cenário
- **Total: 320 execuções**

**Tempo estimado**: 2-5 minutos dependendo do hardware

---

## 📚 Exemplos de Uso

### 1. Demonstração Rápida

Para uma demonstração rápida sem executar o benchmark completo:

```bash
cd src
javac examples/QuickDemo.java
java examples.QuickDemo
```

### 2. Usar Algoritmos Individualmente

```java
import algorithms.*;
import model.SortMetrics;

// Criar array de teste
int[] data = {64, 34, 25, 12, 22, 11, 90};

// Criar algoritmo
SortAlgorithm mergeSort = new MergeSortAlgorithm();

// Ordenar e obter métricas
SortMetrics metrics = mergeSort.sort(data);

// Exibir resultados
System.out.println("Comparações: " + metrics.getComparisons());
System.out.println("Trocas: " + metrics.getSwaps());
System.out.println("Tempo: " + metrics.getExecutionTimeMillis() + " ms");
```

### 3. Gerar Diferentes Tipos de Dados

```java
import generators.*;

// Dados aleatórios
DataGenerator randomGen = new RandomDataGenerator();
int[] randomData = randomGen.generate(1000);

// Dados quase ordenados (10% de perturbação)
DataGenerator nearlySorted = new NearlySortedDataGenerator();
int[] nearlySortedData = nearlySorted.generate(1000);

// Dados em ordem reversa
DataGenerator reverse = new ReverseDataGenerator();
int[] reverseData = reverse.generate(1000);

// Dados com valores repetidos (10 valores distintos)
DataGenerator repeated = new RepeatedValuesDataGenerator(10);
int[] repeatedData = repeated.generate(1000);
```

### 4. Configurar Quick Sort com Diferentes Pivôs

```java
import algorithms.*;

// Quick Sort com último elemento como pivô
QuickSortAlgorithm qs1 = new QuickSortAlgorithm(
    QuickSortAlgorithm.PivotStrategy.LAST
);

// Quick Sort com primeiro elemento como pivô
QuickSortAlgorithm qs2 = new QuickSortAlgorithm(
    QuickSortAlgorithm.PivotStrategy.FIRST
);

// Quick Sort com elemento do meio como pivô
QuickSortAlgorithm qs3 = new QuickSortAlgorithm(
    QuickSortAlgorithm.PivotStrategy.MIDDLE
);

// Quick Sort com mediana de três
QuickSortAlgorithm qs4 = new QuickSortAlgorithm(
    QuickSortAlgorithm.PivotStrategy.MEDIAN_OF_THREE
);
```

### 5. Executar Benchmark Customizado

```java
import benchmark.PerformanceBenchmark;
import algorithms.*;
import generators.*;
import model.BenchmarkResult;
import java.util.*;

// Configurar algoritmos a testar
List<SortAlgorithm> algorithms = Arrays.asList(
    new MergeSortAlgorithm(),
    new HeapSortAlgorithm()
);

// Configurar geradores de dados
List<DataGenerator> generators = Arrays.asList(
    new RandomDataGenerator(),
    new ReverseDataGenerator()
);

// Tamanhos de array
int[] sizes = {1000, 5000, 10000};

// Criar benchmark com 3 repetições
PerformanceBenchmark benchmark = new PerformanceBenchmark(3);

// Executar
List<BenchmarkResult> results = benchmark.runCompleteBenchmark(
    algorithms, generators, sizes
);

// Processar resultados
for (BenchmarkResult result : results) {
    System.out.printf("%s - %s (n=%d): %.3f ms\n",
        result.getAlgorithmName(),
        result.getDataDistribution(),
        result.getArraySize(),
        result.getAvgTimeMillis()
    );
}
```

### 6. Formatar Resultados Personalizados

```java
import analysis.*;
import model.BenchmarkResult;
import java.util.List;

// Após obter resultados do benchmark...

// Tabela consolidada
TableFormatter.printAllResults(results);

// Resultados por distribuição específica
TableFormatter.printResultsByDistribution(results, "Aleatória");

// Comparação para tamanho específico
TableFormatter.printComparisonBySize(results, 10000);

// Resumo de tempos
TableFormatter.printTimeSummary(results);

// Melhores desempenhos
ResultAnalyzer.printBestPerformers(results);
```

---

## ⚙️ Personalizando o Benchmark Principal

Edite `Main.java` para ajustar:

### Tamanhos de Array

```java
private static final int[] ARRAY_SIZES = {1000, 10000, 50000, 100000};
```

**Sugestões**:
- Teste rápido: `{1000, 5000}`
- Teste médio: `{1000, 10000, 50000}`
- Teste completo: `{1000, 10000, 50000, 100000, 500000}`

### Número de Repetições

```java
private static final int REPETITIONS = 5;
```

**Sugestões**:
- Teste rápido: `3`
- Teste normal: `5`
- Teste estatístico: `10` ou mais

### Adicionar/Remover Algoritmos

Em `initializeAlgorithms()`:

```java
private static List<SortAlgorithm> initializeAlgorithms() {
    List<SortAlgorithm> algorithms = new ArrayList<>();
    
    algorithms.add(new MergeSortAlgorithm());
    algorithms.add(new HeapSortAlgorithm());
    algorithms.add(new QuickSortAlgorithm(PivotStrategy.LAST));
    // algorithms.add(new QuickSortAlgorithm(PivotStrategy.MEDIAN_OF_THREE));
    
    return algorithms;
}
```

### Adicionar/Remover Distribuições

Em `initializeGenerators()`:

```java
private static List<DataGenerator> initializeGenerators() {
    List<DataGenerator> generators = new ArrayList<>();
    
    generators.add(new RandomDataGenerator());
    generators.add(new NearlySortedDataGenerator());
    // generators.add(new ReverseDataGenerator());
    // generators.add(new RepeatedValuesDataGenerator(10));
    
    return generators;
}
```

---

## 📊 Interpretando os Resultados

### Tabela de Resultados

```
Algoritmo                 Distribuição         Tamanho    Comparações         Trocas   Tempo (ms) Desvio (ms)       Reps
---------------------------------------------------------------------------------
Merge Sort                Aleatória             10,000         120,459        133,616        2.345        0.123          5
```

- **Comparações**: Número de comparações entre elementos
- **Trocas**: Número de movimentações de elementos
- **Tempo (ms)**: Tempo médio de execução
- **Desvio (ms)**: Desvio padrão do tempo (menor = mais consistente)
- **Reps**: Número de repetições realizadas

### Análise de Complexidade

O sistema mostra complexidades teóricas:
- **O(n log n)**: Crescimento logarítmico - muito eficiente
- **O(n²)**: Crescimento quadrático - ineficiente para grandes n

### Melhores Desempenhos

O sistema identifica automaticamente:
- Algoritmo mais rápido por distribuição
- Algoritmo mais rápido por tamanho
- Algoritmo com menor variância

---

## 🔍 Dicas de Análise

### Para Dados Aleatórios
- Quick Sort geralmente é o mais rápido
- Merge Sort tem desempenho consistente
- Heap Sort é intermediário

### Para Dados Quase Ordenados
- Quick Sort pode degradar dependendo do pivô
- Merge Sort mantém O(n log n)

### Para Dados Reversos
- Quick Sort com pivô no final tem O(n²) - MUITO LENTO
- Merge Sort e Heap Sort mantêm O(n log n)
- Use mediana de três no Quick Sort

### Para Valores Repetidos
- Merge Sort (estável) é preferível se ordem importa
- Quick Sort pode ter bom desempenho

---

## 🐛 Solução de Problemas

### "OutOfMemoryError"
- Reduza `ARRAY_SIZES` ou `REPETITIONS`
- Execute com: `java -Xmx2g Main` (2GB de heap)

### Demora muito tempo
- Reduza `REPETITIONS` para 3
- Use arrays menores: `{1000, 5000, 10000}`
- Comente alguns algoritmos ou distribuições

### Quer apenas testar um cenário
- Use a classe `QuickDemo` 
- Ou crie um programa customizado com o exemplo 5

---

## 📖 Documentação das Classes

### SortAlgorithm (Interface)
- `SortMetrics sort(int[] array)` - Ordena e retorna métricas
- `String getName()` - Nome do algoritmo
- `String getBestCaseComplexity()` - Complexidade melhor caso
- `String getAverageCaseComplexity()` - Complexidade caso médio
- `String getWorstCaseComplexity()` - Complexidade pior caso
- `boolean isStable()` - Se o algoritmo é estável

### DataGenerator (Interface)
- `int[] generate(int size)` - Gera array de tamanho específico
- `String getDistributionName()` - Nome da distribuição
- `String getDescription()` - Descrição detalhada

### SortMetrics
- `long getComparisons()` - Número de comparações
- `long getSwaps()` - Número de trocas
- `long getExecutionTimeNanos()` - Tempo em nanosegundos
- `double getExecutionTimeMillis()` - Tempo em milissegundos

### BenchmarkResult
- Contém estatísticas agregadas de múltiplas execuções
- Média, desvio padrão, mínimo e máximo

---

## 🎓 Uso Acadêmico

### Para Relatórios
1. Execute o benchmark completo
2. Copie as tabelas geradas
3. Use as análises teóricas e práticas
4. Compare com a teoria dos livros

### Para Apresentações
1. Use `QuickDemo` para demonstrações ao vivo
2. Mostre impacto da distribuição de dados
3. Compare pivôs diferentes no Quick Sort
4. Demonstre estabilidade do Merge Sort

### Para Estudos
1. Modifique os algoritmos e observe mudanças
2. Teste diferentes estratégias de pivô
3. Adicione novos algoritmos (Insertion Sort, etc.)
4. Teste com diferentes distribuições

---

**Pronto para começar!** Execute `java Main` e explore os resultados. 🚀

