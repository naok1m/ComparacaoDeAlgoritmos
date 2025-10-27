// SEU NOVO QuickSort.java

public class QuickSort {

    // Contadores estáticos
    private static long comparacoes;
    private static long trocas;
    
    // NOVO: Variável estática para guardar a política de pivô
    // Usamos 'static' para que não precise ser passada em todas as chamadas recursivas.
    private static String politicaPivoAtual;

    // 1. Método público principal - AGORA RECEBE A POLÍTICA
    public static SortStats sort(int[] v, int l, int r, String politicaPivo) {
        // Reseta os contadores
        comparacoes = 0;
        trocas = 0;
        
        // NOVO: Define a política para esta execução
        politicaPivoAtual = politicaPivo; 

        // Mede o tempo
        long t1 = System.nanoTime();
        quickSort(v, l, r); // Chama o método recursivo
        long tempoTotal = System.nanoTime() - t1;

        // Retorna o objeto de estatísticas
        return new SortStats(comparacoes, trocas, tempoTotal);
    }

    // 2. Método recursivo (como antes)
    private static void quickSort(int[] v, int l, int r) {
        if (l < r) {
            int p = particao(v, l, r);
            quickSort(v, l, p - 1);
            quickSort(v, p + 1, r);
        }
    }

    // 3. Método de partição (Modificado)
    private static int particao(int[] v, int l, int r) {
        
        // NOVO: Chama o helper para escolher o pivô ANTES de particionar.
        // Este método move o pivô escolhido para a posição 'r' (final).
        selecionarPivo(v, l, r);
        
        // O resto da lógica é idêntica, pois o pivô está em v[r]
        int pivo = v[r];
        int i = (l - 1);

        for (int j = l; j < r; j++) {
            comparacoes++; 
            if (v[j] < pivo) {
                i++;
                swap(v, i, j); 
            }
        }
        swap(v, i + 1, r); // Troca final do pivô
        return i + 1;
    }

    // 4. NOVO: Método para selecionar o pivô
    private static void selecionarPivo(int[] v, int l, int r) {
        switch (politicaPivoAtual) {
            case "primeiro":
                // Move o primeiro elemento (v[l]) para o final (v[r])
                swap(v, l, r);
                break;

            case "mediana3":
                // Calcula a mediana entre v[l], v[mid], v[r] e a coloca em v[r]
                int mid = (l + r) / 2;
                
                // Ordena os três elementos v[l], v[mid], v[r]
                comparacoes++;
                if (v[l] > v[mid]) swap(v, l, mid);
                
                comparacoes++;
                if (v[l] > v[r]) swap(v, l, r);
                
                comparacoes++;
                if (v[mid] > v[r]) swap(v, mid, r);
                
                // Agora, v[l] <= v[mid] <= v[r]
                // O pivô (mediana) está em v[mid]. Movemos para o final (v[r]).
                swap(v, mid, r);
                break;

            case "ultimo":
            default:
                // Não faz nada. O pivô já é v[r] por padrão.
                break;
        }
    }

    // 5. Método de troca (swap) - como antes
    private static void swap(int[] v, int i, int j) {
        trocas++;
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}