import algorithms.*;
import generators.*;
import benchmark.PerformanceBenchmark;
import model.BenchmarkResult;
import analysis.TableFormatter;
import analysis.ResultAnalyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * Programa principal para comparação de algoritmos de ordenação
 * 
 * Compara Merge Sort, Heap Sort e Quick Sort em diferentes distribuições de dados:
 * - Aleatória
 * - Quase Ordenada (10% de perturbação)
 * - Reversa (decrescente)
 * - Valores Repetidos (poucos valores distintos)
 * 
 * @author Thiago
 * @version 1.0
 */
public class Main {
    
    // Configurações do benchmark
    private static final int[] ARRAY_SIZES = {1000, 10000, 50000, 100000};
    private static final int REPETITIONS = 5;
    
    public static void main(String[] args) {
        printWelcomeMessage();
        
        // Inicializa algoritmos
        List<SortAlgorithm> algorithms = initializeAlgorithms();
        
        // Inicializa geradores de dados
        List<DataGenerator> generators = initializeGenerators();
        
        // Imprime análise teórica
        ResultAnalyzer.printTheoreticalAnalysis(algorithms);
        
        // Executa benchmark
        PerformanceBenchmark benchmark = new PerformanceBenchmark(REPETITIONS);
        List<BenchmarkResult> results = benchmark.runCompleteBenchmark(algorithms, generators, ARRAY_SIZES);
        
        // Apresenta resultados
        presentResults(results, algorithms);
        
        printConclusionMessage();
    }
    
    /**
     * Inicializa os algoritmos de ordenação
     */
    private static List<SortAlgorithm> initializeAlgorithms() {
        List<SortAlgorithm> algorithms = new ArrayList<>();
        
        algorithms.add(new MergeSortAlgorithm());
        algorithms.add(new HeapSortAlgorithm());
        algorithms.add(new QuickSortAlgorithm(QuickSortAlgorithm.PivotStrategy.LAST));
        algorithms.add(new QuickSortAlgorithm(QuickSortAlgorithm.PivotStrategy.MEDIAN_OF_THREE));
        
        return algorithms;
    }
    
    /**
     * Inicializa os geradores de dados
     */
    private static List<DataGenerator> initializeGenerators() {
        List<DataGenerator> generators = new ArrayList<>();
        
        generators.add(new RandomDataGenerator());
        generators.add(new NearlySortedDataGenerator());
        generators.add(new ReverseDataGenerator());
        generators.add(new RepeatedValuesDataGenerator(10));
        
        return generators;
    }
    
    /**
     * Apresenta os resultados em diferentes formatos
     */
    private static void presentResults(List<BenchmarkResult> results, List<SortAlgorithm> algorithms) {
        // Tabela consolidada
        TableFormatter.printAllResults(results);
        
        // Tabelas por distribuição
        System.out.println("\n\n" + "#".repeat(100));
        System.out.println("RESULTADOS DETALHADOS POR DISTRIBUIÇÃO");
        System.out.println("#".repeat(100));
        
        results.stream()
            .map(BenchmarkResult::getDataDistribution)
            .distinct()
            .forEach(dist -> TableFormatter.printResultsByDistribution(results, dist));
        
        // Resumo de tempos
        TableFormatter.printTimeSummary(results);
        
        // Comparação por tamanho
        System.out.println("\n\n" + "#".repeat(100));
        System.out.println("COMPARAÇÕES POR TAMANHO DE ARRAY");
        System.out.println("#".repeat(100));
        
        for (int size : ARRAY_SIZES) {
            TableFormatter.printComparisonBySize(results, size);
        }
        
        // Melhores desempenhos
        ResultAnalyzer.printBestPerformers(results);
        
        // Análise comportamental
        ResultAnalyzer.printBehaviorObservations(results);
    }
    
    /**
     * Imprime mensagem de boas-vindas
     */
    private static void printWelcomeMessage() {
        System.out.println("\n");
        System.out.println("╔" + "═".repeat(98) + "╗");
        System.out.println("║" + " ".repeat(98) + "║");
        System.out.println("║" + centerText("SISTEMA DE COMPARAÇÃO DE ALGORITMOS DE ORDENAÇÃO", 98) + "║");
        System.out.println("║" + " ".repeat(98) + "║");
        System.out.println("║" + centerText("Merge Sort | Heap Sort | Quick Sort", 98) + "║");
        System.out.println("║" + " ".repeat(98) + "║");
        System.out.println("╚" + "═".repeat(98) + "╝");
        System.out.println();
        
        System.out.println("Este sistema realiza uma análise comparativa detalhada de algoritmos de ordenação,");
        System.out.println("medindo desempenho em diferentes cenários e distribuições de dados.");
        System.out.println();
        
        System.out.println("Configurações:");
        System.out.printf("  • Tamanhos de array: ");
        for (int i = 0; i < ARRAY_SIZES.length; i++) {
            System.out.printf("%,d", ARRAY_SIZES[i]);
            if (i < ARRAY_SIZES.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.printf("  • Repetições por cenário: %d\n", REPETITIONS);
        System.out.println("  • Distribuições: Aleatória, Quase Ordenada, Reversa, Valores Repetidos");
        System.out.println();
    }
    
    /**
     * Imprime mensagem de conclusão
     */
    private static void printConclusionMessage() {
        System.out.println("\n\n");
        System.out.println("╔" + "═".repeat(98) + "╗");
        System.out.println("║" + " ".repeat(98) + "║");
        System.out.println("║" + centerText("ANÁLISE CONCLUÍDA COM SUCESSO", 98) + "║");
        System.out.println("║" + " ".repeat(98) + "║");
        System.out.println("╚" + "═".repeat(98) + "╝");
        System.out.println();
        
        System.out.println("CONCLUSÕES PRINCIPAIS:");
        System.out.println();
        System.out.println("1. MERGE SORT:");
        System.out.println("   ✓ Desempenho consistente e previsível");
        System.out.println("   ✓ Ideal quando estabilidade é necessária");
        System.out.println("   ✗ Uso adicional de memória");
        System.out.println();
        
        System.out.println("2. HEAP SORT:");
        System.out.println("   ✓ Garantia de O(n log n) em todos os casos");
        System.out.println("   ✓ Ordenação in-place");
        System.out.println("   ✗ Não estável");
        System.out.println();
        
        System.out.println("3. QUICK SORT:");
        System.out.println("   ✓ Geralmente o mais rápido na prática");
        System.out.println("   ✓ Ordenação in-place");
        System.out.println("   ✗ Desempenho dependente da escolha do pivô");
        System.out.println("   ✗ Pior caso O(n²) se o pivô for mal escolhido");
        System.out.println();
        
        System.out.println("RECOMENDAÇÕES:");
        System.out.println("• Use Merge Sort quando precisar de estabilidade e desempenho garantido");
        System.out.println("• Use Heap Sort quando memória for limitada e estabilidade não for necessária");
        System.out.println("• Use Quick Sort (com mediana de três) para melhor desempenho médio");
        System.out.println();
    }
    
    /**
     * Centraliza texto em uma largura específica
     */
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }
}

