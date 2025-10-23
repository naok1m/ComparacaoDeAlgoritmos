# Sistema de Comparação de Algoritmos de Ordenação

## 📋 Descrição do Projeto

Sistema modular em Java que compara de forma teórica e experimental os algoritmos **Merge Sort**, **Heap Sort** e **Quick Sort**, utilizando princípios de Programação Orientada a Objetos (POO) e apresentando resultados em tabelas padronizadas.

## 🎯 Objetivos

O programa é capaz de:

1. **Gerar conjuntos de dados** com diferentes distribuições:
   - **Aleatória** - distribuição uniforme
   - **Quase Ordenada** - com 10% de perturbação
   - **Reversa** - estritamente decrescente
   - **Valores Repetidos** - amostragem de poucos valores distintos

2. **Implementar algoritmos de ordenação** com métricas:
   - **Merge Sort**: dividir e conquistar, estável
   - **Heap Sort**: árvore binária implícita, não estável
   - **Quick Sort**: particionamento com pivô configurável

3. **Medir desempenho experimental**:
   - Tamanhos: n ∈ {10³, 10⁴, 5·10⁴, 10⁵}
   - Métricas: tempo de execução, comparações, trocas
   - Média de 5 repetições por cenário

4. **Análise comparativa**:
   - Análise teórica (complexidade assintótica)
   - Análise prática (tempos medidos, variância)
   - Observações comportamentais

## 📁 Estrutura do Projeto

```
src/
├── Main.java                          # Programa principal
├── model/                             # Classes de modelo
│   ├── SortMetrics.java              # Métricas de ordenação
│   └── BenchmarkResult.java          # Resultados agregados
├── algorithms/                        # Algoritmos de ordenação
│   ├── SortAlgorithm.java            # Interface
│   ├── MergeSortAlgorithm.java       # Implementação Merge Sort
│   ├── HeapSortAlgorithm.java        # Implementação Heap Sort
│   └── QuickSortAlgorithm.java       # Implementação Quick Sort
├── generators/                        # Geradores de dados
│   ├── DataGenerator.java            # Interface
│   ├── RandomDataGenerator.java      # Dados aleatórios
│   ├── NearlySortedDataGenerator.java # Dados quase ordenados
│   ├── ReverseDataGenerator.java     # Dados em ordem reversa
│   └── RepeatedValuesDataGenerator.java # Valores repetidos
├── benchmark/                         # Sistema de benchmark
│   └── PerformanceBenchmark.java     # Medição de desempenho
└── analysis/                          # Análise e apresentação
    ├── TableFormatter.java           # Formatação de tabelas
    └── ResultAnalyzer.java           # Análise de resultados
```

## 🔧 Como Compilar e Executar

### Opção 1: Eclipse
1. Abra o projeto no Eclipse
2. Clique com botão direito em `Main.java` → Run As → Java Application

### Opção 2: Linha de Comando

```bash
# Compilar
cd src
javac Main.java

# Executar
java Main
```

### Opção 3: Compilar todos os arquivos

```bash
cd src
javac model/*.java algorithms/*.java generators/*.java benchmark/*.java analysis/*.java Main.java
java Main
```

## 📊 Saída do Programa

O programa gera várias tabelas e análises:

### 1. Análise Teórica de Complexidade
Apresenta as complexidades de tempo para cada algoritmo (melhor, médio e pior caso)

### 2. Tabela Consolidada de Resultados
Mostra todas as métricas coletadas:
- Algoritmo
- Distribuição de dados
- Tamanho do array
- Número de comparações
- Número de trocas
- Tempo médio de execução
- Desvio padrão
- Número de repetições

### 3. Resultados por Distribuição
Tabelas separadas para cada tipo de distribuição de dados

### 4. Resumo de Tempos
Matriz comparativa de tempos de execução por algoritmo e tamanho

### 5. Melhores Desempenhos
Identifica o algoritmo mais rápido para cada cenário

### 6. Análise Comportamental
Observações detalhadas sobre o comportamento de cada algoritmo

## 🔬 Algoritmos Implementados

### Merge Sort
- **Complexidade**: O(n log n) em todos os casos
- **Estável**: Sim
- **Espaço**: O(n)
- **Características**: Desempenho consistente e previsível

### Heap Sort
- **Complexidade**: O(n log n) em todos os casos
- **Estável**: Não
- **Espaço**: O(1)
- **Características**: Ordenação in-place, boa eficiência

### Quick Sort
- **Complexidade**: O(n log n) médio, O(n²) pior caso
- **Estável**: Não
- **Espaço**: O(log n)
- **Características**: Rápido na prática, sensível ao pivô
- **Estratégias de pivô**:
  - Último elemento (LAST)
  - Mediana de três (MEDIAN_OF_THREE)

## 📈 Métricas Coletadas

Para cada execução, o sistema coleta:

1. **Comparações**: Número de comparações entre elementos
2. **Trocas/Movimentos**: Número de movimentações de elementos
3. **Tempo de Execução**: Tempo em nanossegundos (convertido para ms)
4. **Estatísticas**: Média, desvio padrão, mínimo e máximo

## 🎓 Conceitos de POO Utilizados

- **Encapsulamento**: Classes com responsabilidades bem definidas
- **Abstração**: Interfaces para algoritmos e geradores
- **Polimorfismo**: Diferentes implementações da mesma interface
- **Modularidade**: Separação em pacotes por funcionalidade

## 📝 Configuração do Benchmark

Você pode ajustar as configurações em `Main.java`:

```java
// Tamanhos de array a serem testados
private static final int[] ARRAY_SIZES = {1000, 10000, 50000, 100000};

// Número de repetições por cenário
private static final int REPETITIONS = 5;
```

## 🔄 Extensibilidade

O sistema foi projetado para ser facilmente extensível:

### Adicionar novo algoritmo:
1. Criar classe que implementa `SortAlgorithm`
2. Implementar método `sort()` com contadores de métricas
3. Adicionar na lista de algoritmos em `Main.java`

### Adicionar nova distribuição:
1. Criar classe que implementa `DataGenerator`
2. Implementar método `generate()`
3. Adicionar na lista de geradores em `Main.java`

## 🎯 Casos de Uso

- Estudo comparativo de algoritmos de ordenação
- Análise de complexidade prática vs teórica
- Benchmark de desempenho em diferentes cenários
- Material didático para disciplinas de algoritmos
- Avaliação de impacto da distribuição de dados

## 📖 Referências

- Cormen, T. H., et al. "Introduction to Algorithms" (CLRS)
- Sedgewick, R. "Algorithms" 4th Edition
- Knuth, D. E. "The Art of Computer Programming, Vol. 3: Sorting and Searching"

## 👨‍💻 Autor

Desenvolvido para a disciplina de Algoritmos - AV2

---

## 🚀 Exemplo de Uso

```java
// Criar algoritmo
SortAlgorithm mergeSort = new MergeSortAlgorithm();

// Gerar dados
DataGenerator generator = new RandomDataGenerator();
int[] data = generator.generate(10000);

// Executar e obter métricas
SortMetrics metrics = mergeSort.sort(data);

System.out.println(metrics); // Exibe comparações, trocas e tempo
```

## 📊 Complexidade Teórica

| Algoritmo   | Melhor Caso | Caso Médio  | Pior Caso   | Estável | Espaço |
|-------------|-------------|-------------|-------------|---------|--------|
| Merge Sort  | O(n log n)  | O(n log n)  | O(n log n)  | Sim     | O(n)   |
| Heap Sort   | O(n log n)  | O(n log n)  | O(n log n)  | Não     | O(1)   |
| Quick Sort  | O(n log n)  | O(n log n)  | O(n²)       | Não     | O(log n)|

---

**Nota**: O sistema foi desenvolvido com foco em clareza, modularidade e facilidade de compreensão, sendo ideal para fins educacionais e análises comparativas.
