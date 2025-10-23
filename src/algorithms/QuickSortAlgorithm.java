package algorithms;

import model.SortMetrics;

/**
 * Implementação do Quick Sort com métricas
 * Algoritmo não estável, utiliza particionamento
 */
public class QuickSortAlgorithm implements SortAlgorithm {
    private SortMetrics metrics;
    
    public enum PivotStrategy {
        FIRST,      // Primeiro elemento
        LAST,       // Último elemento
        MIDDLE,     // Elemento do meio
        MEDIAN_OF_THREE  // Mediana de três
    }
    
    private PivotStrategy pivotStrategy;
    
    public QuickSortAlgorithm() {
        this.pivotStrategy = PivotStrategy.LAST; // Padrão: último elemento
    }
    
    public QuickSortAlgorithm(PivotStrategy strategy) {
        this.pivotStrategy = strategy;
    }
    
    @Override
    public SortMetrics sort(int[] array) {
        metrics = new SortMetrics();
        long startTime = System.nanoTime();
        
        quickSort(array, 0, array.length - 1);
        
        long endTime = System.nanoTime();
        metrics.setExecutionTime(endTime - startTime);
        
        return metrics;
    }
    
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    private int partition(int[] array, int low, int high) {
        // Escolhe e posiciona o pivô
        int pivotIndex = choosePivot(array, low, high);
        swap(array, pivotIndex, high); // Move pivô para o final
        
        int pivot = array[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            metrics.incrementComparisons();
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        
        swap(array, i + 1, high);
        return i + 1;
    }
    
    private int choosePivot(int[] array, int low, int high) {
        switch (pivotStrategy) {
            case FIRST:
                return low;
                
            case MIDDLE:
                return low + (high - low) / 2;
                
            case MEDIAN_OF_THREE:
                int mid = low + (high - low) / 2;
                metrics.incrementComparisons();
                metrics.incrementComparisons();
                
                if (array[low] > array[mid]) {
                    if (array[mid] > array[high]) {
                        return mid;
                    } else if (array[low] > array[high]) {
                        return high;
                    } else {
                        return low;
                    }
                } else {
                    if (array[low] > array[high]) {
                        return low;
                    } else if (array[mid] > array[high]) {
                        return high;
                    } else {
                        return mid;
                    }
                }
                
            case LAST:
            default:
                return high;
        }
    }
    
    private void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            metrics.incrementSwaps();
        }
    }
    
    @Override
    public String getName() {
        return "Quick Sort (" + pivotStrategy.toString().toLowerCase().replace('_', ' ') + ")";
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
        return "O(n²)";
    }
    
    @Override
    public boolean isStable() {
        return false;
    }
}

