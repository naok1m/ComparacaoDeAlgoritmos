import java.util.Random;

public class DataGenerator {

    // MUDANÇA AQUI: Adicionado o parâmetro 'maxValorRepetido' no final
    public static int[] generate(int n, String type, long seed, int maxValorRepetido) {
        Random rand = new Random(seed);
        int[] arr = new int[n];

        switch (type) {
            case "aleatoria":
                for (int i = 0; i < n; i++)
                    arr[i] = rand.nextInt(n * 10);
                break;

            case "quase_ordenada":
                for (int i = 0; i < n; i++)
                    arr[i] = i;
                int swaps = (int) (n * 0.1);
                for (int i = 0; i < swaps; i++) {
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                }
                break;

            case "reversa":
                for (int i = 0; i < n; i++)
                    arr[i] = n - i;
                break;

            case "repetidos":
                // Garante que o valor máximo seja pelo menos 1 (para evitar erro no rand.nextInt)
                int max = Math.max(1, maxValorRepetido); 
                
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(max); 
                }
                break;

            default:
                throw new IllegalArgumentException("Tipo inválido: " + type);
        }

        return arr;
    }
}