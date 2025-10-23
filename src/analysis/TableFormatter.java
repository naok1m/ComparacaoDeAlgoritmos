package analysis;

import model.BenchmarkResult;
import java.util.List;

/**
 * Classe para formatar resultados em tabelas
 */
public class TableFormatter {
    
    /**
     * Formata uma tabela de resultados por distribuição
     */
    public static void printResultsByDistribution(List<BenchmarkResult> results, String distribution) {
        System.out.println("\n" + "=".repeat(140));
        System.out.printf("RESULTADOS: %s\n", distribution.toUpperCase());
        System.out.println("=".repeat(140));
        
        printTableHeader();
        
        results.stream()
            .filter(r -> r.getDataDistribution().equals(distribution))
            .forEach(TableFormatter::printTableRow);
        
        System.out.println("=".repeat(140));
    }
    
    /**
     * Formata uma tabela de resultados por algoritmo
     */
    public static void printResultsByAlgorithm(List<BenchmarkResult> results, String algorithm) {
        System.out.println("\n" + "=".repeat(140));
        System.out.printf("RESULTADOS: %s\n", algorithm.toUpperCase());
        System.out.println("=".repeat(140));
        
        printTableHeader();
        
        results.stream()
            .filter(r -> r.getAlgorithmName().equals(algorithm))
            .forEach(TableFormatter::printTableRow);
        
        System.out.println("=".repeat(140));
    }
    
    /**
     * Formata uma tabela comparativa para um tamanho específico
     */
    public static void printComparisonBySize(List<BenchmarkResult> results, int size) {
        System.out.println("\n" + "=".repeat(140));
        System.out.printf("COMPARAÇÃO PARA TAMANHO n = %d\n", size);
        System.out.println("=".repeat(140));
        
        printTableHeader();
        
        results.stream()
            .filter(r -> r.getArraySize() == size)
            .forEach(TableFormatter::printTableRow);
        
        System.out.println("=".repeat(140));
    }
    
    /**
     * Formata uma tabela consolidada de todos os resultados
     */
    public static void printAllResults(List<BenchmarkResult> results) {
        System.out.println("\n" + "=".repeat(140));
        System.out.println("TABELA CONSOLIDADA DE TODOS OS RESULTADOS");
        System.out.println("=".repeat(140));
        
        printTableHeader();
        
        results.forEach(TableFormatter::printTableRow);
        
        System.out.println("=".repeat(140));
    }
    
    /**
     * Imprime o cabeçalho da tabela
     */
    private static void printTableHeader() {
        System.out.printf("%-25s %-20s %10s %15s %15s %12s %12s %10s\n",
            "Algoritmo", "Distribuição", "Tamanho", "Comparações", "Trocas", "Tempo (ms)", "Desvio (ms)", "Reps");
        System.out.println("-".repeat(140));
    }
    
    /**
     * Imprime uma linha da tabela
     */
    private static void printTableRow(BenchmarkResult result) {
        System.out.printf("%-25s %-20s %,10d %,15.0f %,15.0f %,12.3f %,12.3f %10d\n",
            result.getAlgorithmName(),
            result.getDataDistribution(),
            result.getArraySize(),
            result.getAvgComparisons(),
            result.getAvgSwaps(),
            result.getAvgTimeMillis(),
            result.getStdDevTime(),
            result.getRepetitions());
    }
    
    /**
     * Imprime uma tabela resumida de tempos
     */
    public static void printTimeSummary(List<BenchmarkResult> results) {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("RESUMO DE TEMPOS DE EXECUÇÃO (ms)");
        System.out.println("=".repeat(100));
        
        // Agrupa por algoritmo e tamanho
        System.out.printf("%-25s", "Algoritmo");
        
        // Encontra tamanhos únicos
        int[] sizes = results.stream()
            .mapToInt(BenchmarkResult::getArraySize)
            .distinct()
            .sorted()
            .toArray();
            
        for (int size : sizes) {
            System.out.printf(" %15s", String.format("n=%,d", size));
        }
        System.out.println();
        System.out.println("-".repeat(100));
        
        // Agrupa por algoritmo
        results.stream()
            .map(BenchmarkResult::getAlgorithmName)
            .distinct()
            .forEach(algorithm -> {
                System.out.printf("%-25s", algorithm);
                for (int size : sizes) {
                    double avgTime = results.stream()
                        .filter(r -> r.getAlgorithmName().equals(algorithm) && r.getArraySize() == size)
                        .mapToDouble(BenchmarkResult::getAvgTimeMillis)
                        .average()
                        .orElse(0.0);
                    System.out.printf(" %,15.3f", avgTime);
                }
                System.out.println();
            });
        
        System.out.println("=".repeat(100));
    }
}

