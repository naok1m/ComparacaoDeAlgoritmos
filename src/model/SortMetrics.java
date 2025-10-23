package model;

/**
 * Classe para armazenar métricas de um algoritmo de ordenação
 */
public class SortMetrics {
    private long comparisons;
    private long swaps;
    private long executionTimeNanos;
    
    public SortMetrics() {
        this.comparisons = 0;
        this.swaps = 0;
        this.executionTimeNanos = 0;
    }
    
    public void incrementComparisons() {
        this.comparisons++;
    }
    
    public void incrementSwaps() {
        this.swaps++;
    }
    
    public void addSwaps(long count) {
        this.swaps += count;
    }
    
    public void setExecutionTime(long nanos) {
        this.executionTimeNanos = nanos;
    }
    
    public long getComparisons() {
        return comparisons;
    }
    
    public long getSwaps() {
        return swaps;
    }
    
    public long getExecutionTimeNanos() {
        return executionTimeNanos;
    }
    
    public double getExecutionTimeMillis() {
        return executionTimeNanos / 1_000_000.0;
    }
    
    public void reset() {
        this.comparisons = 0;
        this.swaps = 0;
        this.executionTimeNanos = 0;
    }
    
    @Override
    public String toString() {
        return String.format("Comparisons: %d, Swaps: %d, Time: %.3f ms", 
            comparisons, swaps, getExecutionTimeMillis());
    }
}

