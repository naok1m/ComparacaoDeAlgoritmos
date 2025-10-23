package generators;

/**
 * Interface para geradores de dados
 */
public interface DataGenerator {
    /**
     * Gera um array de inteiros com a distribuição específica
     * @param size Tamanho do array
     * @return Array gerado
     */
    int[] generate(int size);
    
    /**
     * Retorna o nome da distribuição
     */
    String getDistributionName();
    
    /**
     * Retorna uma descrição da distribuição
     */
    String getDescription();
}

