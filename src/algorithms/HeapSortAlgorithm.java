package algorithms;

import model.SortMetrics;

/**
 * Implementação do Heap Sort com métricas
 * Algoritmo não estável, baseado em árvore binária implícita
 */
public class HeapSortAlgorithm implements SortAlgorithm {
    private SortMetrics metrics;
    
    @Override
    public SortMetrics sort(int[] array) {
        metrics = new SortMetrics();
        long startTime = System.nanoTime();
        
        heapSort(array);
        
        long endTime = System.nanoTime();
        metrics.setExecutionTime(endTime - startTime);
        
        return metrics;
    }
    
    private void heapSort(int[] array) {
        int n = array.length;
        
        // Constrói o heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            swap(array, 0, i);
            
            // Chama heapify no heap reduzido
            heapify(array, i, 0);
        }
    }
    
    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Se o filho esquerdo é maior que a raiz
        if (left < n) {
            metrics.incrementComparisons();
            if (array[left] > array[largest]) {
                largest = left;
            }
        }
        
        // Se o filho direito é maior que o maior até agora
        if (right < n) {
            metrics.incrementComparisons();
            if (array[right] > array[largest]) {
                largest = right;
            }
        }
        
        // Se o maior não é a raiz
        if (largest != i) {
            swap(array, i, largest);
            
            // Recursivamente heapify a subárvore afetada
            heapify(array, n, largest);
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        metrics.incrementSwaps();
    }
    
    @Override
    public String getName() {
        return "Heap Sort";
    }
    
    @Override
    public String getBestCaseComplexity() {
        return "O(n log n)";
    }
    
    @Override
    public String getAverageCaseComplexity() {
        return "O(n log n)";
    }
    
    @Override
    public String getWorstCaseComplexity() {
        return "O(n log n)";
    }
    
    @Override
    public boolean isStable() {
        return false;
    }
}

