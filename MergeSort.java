// Nome do arquivo: MergeSort.java
import java.util.Arrays;

public class MergeSort {

    // Variáveis estáticas para contar
    private static long comparacoes;
    private static long trocas; // Na verdade, "movimentos" para o vetor principal

    // 1. Método público principal
    public static SortStats sort(int[] v, int l, int r) {
        // Reseta os contadores
        comparacoes = 0;
        trocas = 0;

        // Mede o tempo
        long t1 = System.nanoTime();
        mergeSort(v, l, r); // Chama o método recursivo
        long tempoTotal = System.nanoTime() - t1;

        // Retorna o objeto de estatísticas
        return new SortStats(comparacoes, trocas, tempoTotal);
    }

    // 2. Método recursivo (privado)
    private static void mergeSort(int[] v, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(v, l, m);
            mergeSort(v, m + 1, r);
            merge(v, l, m, r); // Onde a contagem acontece
        }
    }

    // 3. Método 'merge' (onde a mágica acontece)
    private static void merge(int[] v, int l, int m, int r) {
        // Cria vetores temporários
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia dados para os vetores temporários
        for (int i = 0; i < n1; ++i) {
            L[i] = v[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = v[m + 1 + j];
        }

        // Índices iniciais dos sub-vetores
        int i = 0, j = 0;
        // Índice inicial do vetor 'v' mesclado
        int k = l;

        // Mescla os vetores
        while (i < n1 && j < n2) {
            // INCREMENTA A COMPARAÇÃO AQUI
            comparacoes++;
            if (L[i] <= R[j]) {
                v[k] = L[i];
                i++;
            } else {
                v[k] = R[j];
                j++;
            }
            // INCREMENTA A TROCA/MOVIMENTO AQUI
            trocas++; 
            k++;
        }

        // Copia elementos restantes de L[], se houver
        while (i < n1) {
            v[k] = L[i];
            i++;
            k++;
            // INCREMENTA A TROCA/MOVIMENTO AQUI
            trocas++;
        }

        // Copia elementos restantes de R[], se houver
        while (j < n2) {
            v[k] = R[j];
            j++;
            k++;
            // INCREMENTA A TROCA/MOVIMENTO AQUI
            trocas++;
        }
    }
}