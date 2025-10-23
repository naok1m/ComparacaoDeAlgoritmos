package algorithms;

import model.SortMetrics;

/**
 * Implementação do Merge Sort com métricas
 * Algoritmo estável, dividir e conquistar
 */
public class MergeSortAlgorithm implements SortAlgorithm {
    private SortMetrics metrics;
    
    @Override
    public SortMetrics sort(int[] array) {
        metrics = new SortMetrics();
        long startTime = System.nanoTime();
        
        mergeSort(array, 0, array.length - 1);
        
        long endTime = System.nanoTime();
        metrics.setExecutionTime(endTime - startTime);
        
        return metrics;
    }
    
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copia dados para arrays temporários
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
            metrics.addSwaps(1); // Contabiliza cópias como movimentos
        }
        
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
            metrics.addSwaps(1);
        }
        
        // Merge dos arrays temporários
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            metrics.incrementComparisons();
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            metrics.addSwaps(1);
            k++;
        }
        
        // Copia elementos restantes
        while (i < n1) {
            array[k] = leftArray[i];
            metrics.addSwaps(1);
            i++;
            k++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            metrics.addSwaps(1);
            j++;
            k++;
        }
    }
    
    @Override
    public String getName() {
        return "Merge Sort";
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
        return true;
    }
}

