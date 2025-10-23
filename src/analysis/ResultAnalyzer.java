package analysis;

import algorithms.SortAlgorithm;
import model.BenchmarkResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe para análise e interpretação de resultados
 */
public class ResultAnalyzer {
    
    /**
     * Imprime análise teórica dos algoritmos
     */
    public static void printTheoreticalAnalysis(List<SortAlgorithm> algorithms) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("ANÁLISE TEÓRICA DE COMPLEXIDADE");
        System.out.println("=".repeat(100));
        
        System.out.printf("%-30s %-15s %-15s %-15s %-10s\n",
            "Algoritmo", "Melhor Caso", "Caso Médio", "Pior Caso", "Estável");
        System.out.println("-".repeat(100));
        
        for (SortAlgorithm algorithm : algorithms) {
            System.out.printf("%-30s %-15s %-15s %-15s %-10s\n",
                algorithm.getName(),
                algorithm.getBestCaseComplexity(),
                algorithm.getAverageCaseComplexity(),
                algorithm.getWorstCaseComplexity(),
                algorithm.isStable() ? "Sim" : "Não");
        }
        
        System.out.println("=".repeat(100));
    }
    
    /**
     * Imprime observações sobre o comportamento dos algoritmos
     */
    public static void printBehaviorObservations(List<BenchmarkResult> results) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("OBSERVAÇÕES E ANÁLISE COMPORTAMENTAL");
        System.out.println("=".repeat(100));
        System.out.println();
        
        analyzeMergeSort(results);
        analyzeHeapSort(results);
        analyzeQuickSort(results);
        analyzeDistributions(results);
        
        System.out.println("=".repeat(100));
    }
    
    private static void analyzeMergeSort(List<BenchmarkResult> results) {
        System.out.println(">>> MERGE SORT:");
        System.out.println("  • Complexidade consistente O(n log n) em todos os casos");
        System.out.println("  • Desempenho previsível independente da distribuição");
        System.out.println("  • Maior número de movimentos devido às cópias para arrays auxiliares");
        System.out.println("  • Estável: mantém ordem relativa de elementos iguais");
        System.out.println("  • Uso adicional de memória O(n)");
        
        double avgTimeRandom = getAverageTime(results, "Merge Sort", "Aleatória");
        double avgTimeReverse = getAverageTime(results, "Merge Sort", "Reversa");
        System.out.printf("  • Variação de tempo: Aleatória vs Reversa = %.2f%%\n", 
            Math.abs(avgTimeRandom - avgTimeReverse) / avgTimeRandom * 100);
        System.out.println();
    }
    
    private static void analyzeHeapSort(List<BenchmarkResult> results) {
        System.out.println(">>> HEAP SORT:");
        System.out.println("  • Complexidade O(n log n) garantida em todos os casos");
        System.out.println("  • Ordenação in-place: O(1) de memória adicional");
        System.out.println("  • Não estável: pode alterar ordem de elementos iguais");
        System.out.println("  • Menor número de comparações que Merge Sort em muitos casos");
        System.out.println("  • Padrão de acesso à memória menos favorável ao cache");
        
        double avgSwapsRandom = getAverageSwaps(results, "Heap Sort", "Aleatória");
        double avgSwapsMerge = getAverageSwaps(results, "Merge Sort", "Aleatória");
        System.out.printf("  • Trocas em relação ao Merge Sort: %.2f%%\n", 
            (avgSwapsRandom / avgSwapsMerge) * 100);
        System.out.println();
    }
    
    private static void analyzeQuickSort(List<BenchmarkResult> results) {
        System.out.println(">>> QUICK SORT:");
        System.out.println("  • Caso médio O(n log n), pior caso O(n²)");
        System.out.println("  • Desempenho fortemente dependente da escolha do pivô");
        System.out.println("  • Geralmente o mais rápido na prática para dados aleatórios");
        System.out.println("  • Não estável na implementação padrão");
        System.out.println("  • Ordenação in-place com O(log n) de memória para recursão");
        
        double avgTimeRandom = getAverageTime(results, "Quick Sort (last)", "Aleatória");
        double avgTimeReverse = getAverageTime(results, "Quick Sort (last)", "Reversa");
        System.out.printf("  • Performance degradada em ordem reversa: %.2fx mais lento\n", 
            avgTimeReverse / avgTimeRandom);
        System.out.println();
    }
    
    private static void analyzeDistributions(List<BenchmarkResult> results) {
        System.out.println(">>> ANÁLISE POR DISTRIBUIÇÃO:");
        System.out.println();
        
        System.out.println("  • ALEATÓRIA:");
        System.out.println("    - Caso médio para todos os algoritmos");
        System.out.println("    - Quick Sort geralmente mais rápido");
        System.out.println();
        
        System.out.println("  • QUASE ORDENADA:");
        System.out.println("    - Merge Sort mantém desempenho consistente");
        System.out.println("    - Quick Sort pode ter bom desempenho dependendo do pivô");
        System.out.println();
        
        System.out.println("  • REVERSA:");
        System.out.println("    - Pior caso para Quick Sort com pivô no final");
        System.out.println("    - Merge Sort e Heap Sort mantêm O(n log n)");
        System.out.println();
        
        System.out.println("  • VALORES REPETIDOS:");
        System.out.println("    - Muitas comparações com resultados iguais");
        System.out.println("    - Merge Sort (estável) preserva ordem original de elementos iguais");
        System.out.println();
    }
    
    /**
     * Encontra o algoritmo mais rápido para cada cenário
     */
    public static void printBestPerformers(List<BenchmarkResult> results) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("MELHORES DESEMPENHOS POR CENÁRIO");
        System.out.println("=".repeat(100));
        
        // Agrupa por distribuição e tamanho
        results.stream()
            .map(BenchmarkResult::getDataDistribution)
            .distinct()
            .forEach(distribution -> {
                System.out.printf("\n>>> %s:\n", distribution);
                
                results.stream()
                    .filter(r -> r.getDataDistribution().equals(distribution))
                    .collect(Collectors.groupingBy(BenchmarkResult::getArraySize))
                    .forEach((size, resultsList) -> {
                        BenchmarkResult fastest = resultsList.stream()
                            .min((r1, r2) -> Double.compare(r1.getAvgTimeMillis(), r2.getAvgTimeMillis()))
                            .orElse(null);
                            
                        if (fastest != null) {
                            System.out.printf("  n=%,10d: %-30s (%.3f ms)\n", 
                                size, fastest.getAlgorithmName(), fastest.getAvgTimeMillis());
                        }
                    });
            });
        
        System.out.println("\n" + "=".repeat(100));
    }
    
    // Métodos auxiliares
    private static double getAverageTime(List<BenchmarkResult> results, String algorithm, String distribution) {
        return results.stream()
            .filter(r -> r.getAlgorithmName().equals(algorithm) && r.getDataDistribution().equals(distribution))
            .mapToDouble(BenchmarkResult::getAvgTimeMillis)
            .average()
            .orElse(0.0);
    }
    
    private static double getAverageSwaps(List<BenchmarkResult> results, String algorithm, String distribution) {
        return results.stream()
            .filter(r -> r.getAlgorithmName().equals(algorithm) && r.getDataDistribution().equals(distribution))
            .mapToDouble(BenchmarkResult::getAvgSwaps)
            .average()
            .orElse(0.0);
    }
}

