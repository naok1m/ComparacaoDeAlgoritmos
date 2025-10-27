// Nome do arquivo: HeapSort.java

public class HeapSort {

    // Variáveis estáticas para contar
    private static long comparacoes;
    private static long trocas;

    // 1. Método público principal
    public static SortStats sort(int[] v) {
        // Reseta os contadores
        comparacoes = 0;
        trocas = 0;
        int n = v.length;

        // Mede o tempo
        long t1 = System.nanoTime();
        
        // 1. Constrói o heap (rearranja o vetor)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(v, n, i);
        }

        // 2. Extrai um por um os elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (maior) para o fim
            swap(v, 0, i); // Chama nosso método de troca
            heapify(v, i, 0);
        }
        long tempoTotal = System.nanoTime() - t1;

        // Retorna o objeto de estatísticas
        return new SortStats(comparacoes, trocas, tempoTotal);
    }

    // 2. Método 'heapify' (onde a maior parte da contagem ocorre)
    private static void heapify(int[] v, int n, int i) {
        int largest = i;     // Inicializa o maior como raiz
        int l = 2 * i + 1; // filho da esquerda
        int r = 2 * i + 2; // filho da direita

        // Se o filho da esquerda é maior que a raiz
        // INCREMENTA A COMPARAÇÃO AQUI
        comparacoes++;
        if (l < n && v[l] > v[largest]) {
            largest = l;
        }

        // Se o filho da direita é maior que o 'largest' atual
        // INCREMENTA A COMPARAÇÃO AQUI
        comparacoes++;
        if (r < n && v[r] > v[largest]) {
            largest = r;
        }

        // Se o 'largest' não é mais a raiz
        if (largest != i) {
            swap(v, i, largest); // Chama nosso método de troca

            // Recursivamente chama 'heapify' para a sub-árvore afetada
            heapify(v, n, largest);
        }
    }

    // 3. Método de troca (swap)
    private static void swap(int[] v, int i, int j) {
        // INCREMENTA A TROCA AQUI
        trocas++;
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}