package generators;

import java.util.Random;

/**
 * Gerador de dados quase ordenados com 10% de perturbação
 */
public class NearlySortedDataGenerator implements DataGenerator {
    private Random random;
    private double perturbationRate;
    
    public NearlySortedDataGenerator() {
        this.random = new Random();
        this.perturbationRate = 0.1; // 10% de perturbação
    }
    
    public NearlySortedDataGenerator(long seed) {
        this.random = new Random(seed);
        this.perturbationRate = 0.1;
    }
    
    public NearlySortedDataGenerator(double perturbationRate) {
        this.random = new Random();
        this.perturbationRate = perturbationRate;
    }
    
    @Override
    public int[] generate(int size) {
        int[] array = new int[size];
        
        // Gera array ordenado
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        
        // Perturba uma porcentagem dos elementos
        int perturbations = (int) (size * perturbationRate);
        for (int i = 0; i < perturbations; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            
            // Troca dois elementos aleatórios
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        
        return array;
    }
    
    @Override
    public String getDistributionName() {
        return "Quase Ordenada";
    }
    
    @Override
    public String getDescription() {
        return String.format("Array quase ordenado com %.0f%% de perturbação", perturbationRate * 100);
    }
}

