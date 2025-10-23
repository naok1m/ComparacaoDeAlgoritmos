package generators;

import java.util.Random;

/**
 * Gerador de dados com muitos valores repetidos
 * Usa amostragem de poucos valores distintos
 */
public class RepeatedValuesDataGenerator implements DataGenerator {
    private Random random;
    private int distinctValuesCount;
    
    public RepeatedValuesDataGenerator() {
        this.random = new Random();
        this.distinctValuesCount = 10; // Padrão: 10 valores distintos
    }
    
    public RepeatedValuesDataGenerator(long seed) {
        this.random = new Random(seed);
        this.distinctValuesCount = 10;
    }
    
    public RepeatedValuesDataGenerator(int distinctValuesCount) {
        this.random = new Random();
        this.distinctValuesCount = distinctValuesCount;
    }
    
    @Override
    public int[] generate(int size) {
        int[] array = new int[size];
        
        // Gera apenas alguns valores distintos
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(distinctValuesCount);
        }
        
        return array;
    }
    
    @Override
    public String getDistributionName() {
        return "Valores Repetidos";
    }
    
    @Override
    public String getDescription() {
        return String.format("Array com muitas repetições (%d valores distintos)", distinctValuesCount);
    }
}

