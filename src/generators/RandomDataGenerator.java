package generators;

import java.util.Random;

/**
 * Gerador de dados aleatórios (distribuição uniforme)
 */
public class RandomDataGenerator implements DataGenerator {
    private Random random;
    private int maxValue;
    
    public RandomDataGenerator() {
        this.random = new Random();
        this.maxValue = 100000;
    }
    
    public RandomDataGenerator(long seed) {
        this.random = new Random(seed);
        this.maxValue = 100000;
    }
    
    public RandomDataGenerator(int maxValue) {
        this.random = new Random();
        this.maxValue = maxValue;
    }
    
    @Override
    public int[] generate(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }
    
    @Override
    public String getDistributionName() {
        return "Aleatória";
    }
    
    @Override
    public String getDescription() {
        return "Distribuição uniforme aleatória";
    }
}

