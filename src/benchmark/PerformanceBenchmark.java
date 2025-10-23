package benchmark;

import algorithms.SortAlgorithm;
import generators.DataGenerator;
import model.BenchmarkResult;
import model.SortMetrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe para realizar benchmarks de algoritmos de ordenação
 */
public class PerformanceBenchmark {
    private int repetitions;
    
    public PerformanceBenchmark(int repetitions) {
        this.repetitions = repetitions;
    }
    
    /**
     * Executa um benchmark completo de um algoritmo em uma distribuição específica
     */
    public BenchmarkResult runBenchmark(SortAlgorithm algorithm, DataGenerator generator, int arraySize) {
        List<SortMetrics> allMetrics = new ArrayList<>();
        
        System.out.printf("  Executando %s com %s (n=%d)...\n", 
            algorithm.getName(), generator.getDistributionName(), arraySize);
        
        for (int i = 0; i < repetitions; i++) {
            // Gera novos dados para cada repetição
            int[] data = generator.generate(arraySize);
            
            // Cria uma cópia para garantir que estamos ordenando dados frescos
            int[] arrayCopy = Arrays.copyOf(data, data.length);
            
            // Executa o algoritmo e coleta métricas
            SortMetrics metrics = algorithm.sort(arrayCopy);
            allMetrics.add(metrics);
            
            // Verifica se o array foi ordenado corretamente
            if (!isSorted(arrayCopy)) {
                System.err.println("ERRO: Array não foi ordenado corretamente!");
            }
        }
        
        // Calcula estatísticas
        return calculateStatistics(algorithm.getName(), generator.getDistributionName(), 
                                   arraySize, allMetrics);
    }
    
    /**
     * Calcula estatísticas a partir das métricas coletadas
     */
    private BenchmarkResult calculateStatistics(String algorithmName, String distribution, 
                                                int arraySize, List<SortMetrics> metricsList) {
        BenchmarkResult result = new BenchmarkResult(algorithmName, distribution, arraySize, repetitions);
        
        // Calcula médias
        double avgComparisons = metricsList.stream()
            .mapToLong(SortMetrics::getComparisons)
            .average()
            .orElse(0.0);
            
        double avgSwaps = metricsList.stream()
            .mapToLong(SortMetrics::getSwaps)
            .average()
            .orElse(0.0);
            
        double avgTimeMillis = metricsList.stream()
            .mapToDouble(SortMetrics::getExecutionTimeMillis)
            .average()
            .orElse(0.0);
        
        result.setAverages(avgComparisons, avgSwaps, avgTimeMillis);
        
        // Calcula desvio padrão e min/max do tempo
        long[] times = metricsList.stream()
            .mapToLong(SortMetrics::getExecutionTimeNanos)
            .toArray();
            
        double stdDev = calculateStandardDeviation(times);
        long minTime = Arrays.stream(times).min().orElse(0);
        long maxTime = Arrays.stream(times).max().orElse(0);
        
        result.setTimeStatistics(stdDev / 1_000_000.0, minTime, maxTime);
        
        return result;
    }
    
    /**
     * Calcula o desvio padrão
     */
    private double calculateStandardDeviation(long[] values) {
        if (values.length == 0) return 0.0;
        
        double mean = Arrays.stream(values).average().orElse(0.0);
        double variance = Arrays.stream(values)
            .mapToDouble(v -> Math.pow(v - mean, 2))
            .average()
            .orElse(0.0);
            
        return Math.sqrt(variance);
    }
    
    /**
     * Verifica se um array está ordenado
     */
    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Executa uma bateria completa de testes
     */
    public List<BenchmarkResult> runCompleteBenchmark(
            List<SortAlgorithm> algorithms,
            List<DataGenerator> generators,
            int[] arraySizes) {
        
        List<BenchmarkResult> results = new ArrayList<>();
        
        System.out.println("=".repeat(80));
        System.out.println("INICIANDO BENCHMARK DE ALGORITMOS DE ORDENAÇÃO");
        System.out.println("=".repeat(80));
        System.out.printf("Repetições por cenário: %d\n", repetitions);
        System.out.printf("Tamanhos de array: %s\n", Arrays.toString(arraySizes));
        System.out.println("=".repeat(80));
        System.out.println();
        
        int totalTests = algorithms.size() * generators.size() * arraySizes.length;
        int currentTest = 0;
        
        for (DataGenerator generator : generators) {
            System.out.printf("\n>>> Distribuição: %s (%s)\n", 
                generator.getDistributionName(), generator.getDescription());
            
            for (int size : arraySizes) {
                System.out.printf("\n  Tamanho do array: %d\n", size);
                
                for (SortAlgorithm algorithm : algorithms) {
                    currentTest++;
                    System.out.printf("  [%d/%d] ", currentTest, totalTests);
                    
                    BenchmarkResult result = runBenchmark(algorithm, generator, size);
                    results.add(result);
                }
            }
        }
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("BENCHMARK CONCLUÍDO!");
        System.out.println("=".repeat(80));
        
        return results;
    }
}

