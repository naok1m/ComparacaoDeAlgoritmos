import java.util.Scanner;

public class MainExperimento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Definição dos Experimentos (Interativo) ---
        
        System.out.print("Digite o tamanho do vetor (n): ");
        int n = sc.nextInt(); 

        System.out.print("Número de repetições (k) para cada experimento: ");
        int k = sc.nextInt();

        System.out.print("Para a distribuição 'repetidos', qual o valor MÁXIMO (range de 0 a X)? ");
        int maxValorRepetido = sc.nextInt();

        // Menu numérico para a política de pivô
        System.out.println("\nEscolha a Política de pivô para QuickSort:");
        System.out.println("1 - Primeiro elemento");
        System.out.println("2 - Último elemento");
        System.out.println("3 - Mediana de 3 (primeiro, meio, último)");
        System.out.print("Opção: ");
        int escolhaPivo = sc.nextInt();

        String politicaPivo;
        switch (escolhaPivo) {
            case 1: politicaPivo = "primeiro"; break;
            case 3: politicaPivo = "mediana3"; break;
            case 2: default: politicaPivo = "ultimo"; break;
        }

        System.out.println("Usando política: " + politicaPivo);

        String[] distribuicoes = { "aleatoria", "quase_ordenada", "reversa", "repetidos" };
        long seed = 12345L;

        // --- Impressão do Cabeçalho da Tabela ---
        System.out.println("\n===== Tabela-Modelo de Resultados (n = " + n + ", k = " + k + ") =====");
        
        // NOVO: Adicionada a coluna "Rep #" e renomeado "Tempo (ms)"
        System.out.printf("%-6s | %-10s | %-15s | %-12s | %-10s | %-10s | %-18s | %-15s | %-15s\n",
                "Rep #", "n", "Distribuição", "Algoritmo", "Teórico", "Prático", "Tempo (ms)", "#Comp.", "#Trocas/Moves");
        
        // Aumentei a linha separadora para caber a nova coluna
        System.out.println(new String(new char[130]).replace('\0', '-'));

        // === Loop Principal (por distribuição) ===
        for (String tipo : distribuicoes) {
            
            // --- Variáveis de total/média REMOVIDAS ---

            // Loop das 'k' repetições
            for (int rep = 1; rep <= k; rep++) {
                
                int[] base = DataGenerator.generate(n, tipo, seed + rep, maxValorRepetido); 

                // --- MergeSort ---
                int[] v1 = base.clone();
                SortStats statsMerge = MergeSort.sort(v1, 0, n - 1); 

                // --- HeapSort ---
                int[] v2 = base.clone();
                SortStats statsHeap = HeapSort.sort(v2); 

                // --- QuickSort (usando a política) ---
                int[] v3 = base.clone();
                SortStats statsQuick = QuickSort.sort(v3, 0, n - 1, politicaPivo); 

                // NOVO: Calcula o tempo em ms para esta repetição específica
                double tempoMerge = statsMerge.tempoExecucao / 1e6;
                double tempoHeap = statsHeap.tempoExecucao / 1e6;
                double tempoQuick = statsQuick.tempoExecucao / 1e6;

                // NOVO: Imprime as 3 linhas de resultado AQUI DENTRO do loop 'k'
                // Os valores são os dados brutos de 'stats...', não as médias
                // Note o %-15d para imprimir os contadores (long)
                
                System.out.printf("%-6d | %-10d | %-15s | %-12s | %-10s | %-10s | %-18.3f | %-15d | %-15d\n",
                        rep, n, tipo, "MergeSort", "O(n log n)", "O(n log n)", tempoMerge, statsMerge.comparacoes, statsMerge.trocas);

                System.out.printf("%-6d | %-10d | %-15s | %-12s | %-10s | %-10s | %-18.3f | %-15d | %-15d\n",
                        rep, n, tipo, "HeapSort", "O(n log n)", "O(n log n)", tempoHeap, statsHeap.comparacoes, statsHeap.trocas);

                System.out.printf("%-6d | %-10d | %-15s | %-12s | %-10s | %-10s | %-18.3f | %-15d | %-15d\n",
                        rep, n, tipo, "QuickSort", "O(n log n)", "O(n log n)", tempoQuick, statsQuick.comparacoes, statsQuick.trocas);
                
                // NOVO: Adiciona um separador leve entre as repetições
                if (rep < k) {
                    System.out.println(new String(new char[130]).replace('\0', '.'));
                }

            } // --- Fim do loop 'k' ---
            
            // Imprime um separador forte entre as distribuições
            System.out.println(new String(new char[130]).replace('\0', '-'));
            
        } // --- Fim do loop 'tipo' ---
        
        // --- Documentação do sistema (como antes) ---
        System.out.println("\n===== Configuração do Ambiente de Teste =====");
        System.out.println("\nMáquina:");
        System.out.printf("  Sistema Operacional: %s (Versão: %s)\n", System.getProperty("os.name"), System.getProperty("os.version"));
        System.out.printf("  Arquitetura:         %s\n", System.getProperty("os.arch"));
        System.out.printf("  Processadores (Núcleos lógicos): %d\n", Runtime.getRuntime().availableProcessors());
        
        System.out.println("\nJava (JDK):");
        System.out.printf("  Versão do Java:      %s\n", System.getProperty("java.version"));
        System.out.printf("  VM (Máquina Virtual):%s (%s)\n", System.getProperty("java.vm.name"), System.getProperty("java.vm.version"));

        sc.close(); 
    }
}