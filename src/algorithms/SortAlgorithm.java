package algorithms;

import model.SortMetrics;

/**
 * Interface para algoritmos de ordenação
 */
public interface SortAlgorithm {
    /**
     * Ordena o array e retorna as métricas de desempenho
     * @param array Array a ser ordenado (será modificado)
     * @return Métricas de desempenho da ordenação
     */
    SortMetrics sort(int[] array);
    
    /**
     * Retorna o nome do algoritmo
     */
    String getName();
    
    /**
     * Retorna a complexidade teórica no melhor caso
     */
    String getBestCaseComplexity();
    
    /**
     * Retorna a complexidade teórica no caso médio
     */
    String getAverageCaseComplexity();
    
    /**
     * Retorna a complexidade teórica no pior caso
     */
    String getWorstCaseComplexity();
    
    /**
     * Indica se o algoritmo é estável
     */
    boolean isStable();
}

