package model;

/**
 * Classe para armazenar resultados agregados de benchmark
 */
public class BenchmarkResult {
    private String algorithmName;
    private String dataDistribution;
    private int arraySize;
    private int repetitions;
    
    private double avgComparisons;
    private double avgSwaps;
    private double avgTimeMillis;
    
    private double stdDevTime;
    private long minTime;
    private long maxTime;
    
    public BenchmarkResult(String algorithmName, String dataDistribution, int arraySize, int repetitions) {
        this.algorithmName = algorithmName;
        this.dataDistribution = dataDistribution;
        this.arraySize = arraySize;
        this.repetitions = repetitions;
    }
    
    public void setAverages(double avgComparisons, double avgSwaps, double avgTimeMillis) {
        this.avgComparisons = avgComparisons;
        this.avgSwaps = avgSwaps;
        this.avgTimeMillis = avgTimeMillis;
    }
    
    public void setTimeStatistics(double stdDev, long min, long max) {
        this.stdDevTime = stdDev;
        this.minTime = min;
        this.maxTime = max;
    }
    
    // Getters
    public String getAlgorithmName() { return algorithmName; }
    public String getDataDistribution() { return dataDistribution; }
    public int getArraySize() { return arraySize; }
    public int getRepetitions() { return repetitions; }
    public double getAvgComparisons() { return avgComparisons; }
    public double getAvgSwaps() { return avgSwaps; }
    public double getAvgTimeMillis() { return avgTimeMillis; }
    public double getStdDevTime() { return stdDevTime; }
    public long getMinTime() { return minTime; }
    public long getMaxTime() { return maxTime; }
}

