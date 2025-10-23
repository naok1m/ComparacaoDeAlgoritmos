package examples;

import algorithms.*;
import generators.*;
import model.SortMetrics;

/**
 * Demonstração rápida do uso dos algoritmos
 */
public class QuickDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO RÁPIDA ===\n");
        
        // Configura tamanho pequeno para visualização
        int size = 20;
        
        // Gera dados aleatórios
        DataGenerator generator = new RandomDataGenerator(100);
        int[] data = generator.generate(size);
        
        System.out.println("Array original (primeiros elementos):");
        printArray(data, 20);
        
        // Testa cada algoritmo
        testAlgorithm(new MergeSortAlgorithm(), data.clone());
        testAlgorithm(new HeapSortAlgorithm(), data.clone());
        testAlgorithm(new QuickSortAlgorithm(), data.clone());
        
        System.out.println("\n=== COMPARAÇÃO DE DISTRIBUIÇÕES ===\n");
        compareDistributions();
    }
    
    private static void testAlgorithm(SortAlgorithm algorithm, int[] data) {
        System.out.println("\n--- " + algorithm.getName() + " ---");
        
        SortMetrics metrics = algorithm.sort(data);
        
        System.out.println("Array ordenado (primeiros elementos):");
        printArray(data, 20);
        
        System.out.printf("Comparações: %,d\n", metrics.getComparisons());
        System.out.printf("Trocas: %,d\n", metrics.getSwaps());
        System.out.printf("Tempo: %.3f ms\n", metrics.getExecutionTimeMillis());
        
        // Informações teóricas
        System.out.printf("Complexidade - Melhor: %s, Médio: %s, Pior: %s\n",
            algorithm.getBestCaseComplexity(),
            algorithm.getAverageCaseComplexity(),
            algorithm.getWorstCaseComplexity());
        System.out.printf("Estável: %s\n", algorithm.isStable() ? "Sim" : "Não");
    }
    
    private static void compareDistributions() {
        int size = 10000;
        SortAlgorithm algorithm = new QuickSortAlgorithm();
        
        // Testa cada distribuição
        DataGenerator[] generators = {
            new RandomDataGenerator(),
            new NearlySortedDataGenerator(),
            new ReverseDataGenerator(),
            new RepeatedValuesDataGenerator(10)
        };
        
        for (DataGenerator generator : generators) {
            int[] data = generator.generate(size);
            SortMetrics metrics = algorithm.sort(data);
            
            System.out.printf("%-20s: %,d comparações, %,d trocas, %.3f ms\n",
                generator.getDistributionName(),
                metrics.getComparisons(),
                metrics.getSwaps(),
                metrics.getExecutionTimeMillis());
        }
    }
    
    private static void printArray(int[] array, int maxElements) {
        int limit = Math.min(array.length, maxElements);
        System.out.print("  [");
        for (int i = 0; i < limit; i++) {
            System.out.print(array[i]);
            if (i < limit - 1) System.out.print(", ");
        }
        if (array.length > maxElements) {
            System.out.print(", ...");
        }
        System.out.println("]");
    }
}

