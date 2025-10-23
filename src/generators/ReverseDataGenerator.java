package generators;

/**
 * Gerador de dados em ordem reversa (estritamente decrescente)
 */
public class ReverseDataGenerator implements DataGenerator {
    
    @Override
    public int[] generate(int size) {
        int[] array = new int[size];
        
        // Gera array em ordem decrescente
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        
        return array;
    }
    
    @Override
    public String getDistributionName() {
        return "Reversa";
    }
    
    @Override
    public String getDescription() {
        return "Array em ordem estritamente decrescente";
    }
}

