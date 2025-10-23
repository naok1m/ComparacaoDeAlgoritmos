import java.util.*;

public class SortingComparison {

    // ============================
    // Main
    // ============================
    public static void main(String[] args) {

        // 1. Configurações
        int[] sizes = {1000, 5000, 10000};   // tamanhos dos vetores
        int repetitions = 5;                  // k repetições
        String[] distributions = {"random", "almost_sorted", "reversed", "few_unique"};

        // 2. Para cada distribuição e tamanho
        for (String dist : distributions) {
            System.out.println("\nDistribuição: " + dist);
            for (int n : sizes) {
                System.out.println("\nTamanho n = " + n);

                // 2a. Gerar vetor base
                int[] base = generateArray(n, dist);

                // Clonar para cada algoritmo
                int[] arrMerge = base.clone();
                int[] arrHeap = base.clone();
                int[] arrQuick = base.clone();

                // 2b. Executar MergeSort
                Result mergeResult = runMergeSort(arrMerge, repetitions);

                // 2b. Executar HeapSort
                Result heapResult = runHeapSort(arrHeap, repetitions);

                // 2b. Executar QuickSort (pivô aleatório)

                // 2c. Consolidar e exibir resultados
                System.out.printf("%-12s %-12s %-12s %-12s\n", "Algoritmo", "Tempo(ms)", "Comparações", "Ordenado?");
                System.out.printf("%-12s %-12.2f %-12d %-12b\n", "MergeSort", mergeResult.time, mergeResult.comparisons, mergeResult.isSorted);
                System.out.printf("%-12s %-12.2f %-12d %-12b\n", "HeapSort", heapResult.time, heapResult.comparisons, heapResult.isSorted);

                // 2d. Síntese simples
                double bestTime = Math.min(mergeResult.time, heapResult.time);
                String bestAlgo = bestTime == mergeResult.time ? "MergeSort" : bestTime == heapResult.time ? "HeapSort" : "QuickSort";
                System.out.println("→ Melhor tempo: " + bestAlgo + "\n");
            }
        }
    }

    // ============================
    // Estrutura para resultados
    // ============================
    static class Result {
        double time;
        int comparisons;
        boolean isSorted;

        public Result(double time, int comparisons, boolean isSorted) {
            this.time = time;
            this.comparisons = comparisons;
            this.isSorted = isSorted;
        }
    }

    // ============================
    // 2a. Gerar arrays
    // ============================
    static int[] generateArray(int n, String distribution) {
        Random rand = new Random();
        int[] arr = new int[n];

        switch (distribution) {
            case "random":
                for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
                break;

            case "almost_sorted":
                for (int i = 0; i < n; i++) arr[i] = i;
                int perturb = (int)(0.1 * n);
                for (int i = 0; i < perturb; i++) {
                    int a = rand.nextInt(n);
                    int b = rand.nextInt(n);
                    int tmp = arr[a];
                    arr[a] = arr[b];
                    arr[b] = tmp;
                }
                break;

            case "reversed":
                for (int i = 0; i < n; i++) arr[i] = n - i;
                break;

            case "few_unique":
                int[] values = {0, 1, 2, 3, 4};
                for (int i = 0; i < n; i++) arr[i] = values[rand.nextInt(values.length)];
                break;

            default:
                throw new IllegalArgumentException("Distribuição inválida");
        }

        return arr;
    }

    // ============================
    // Run MergeSort
    // ============================
    static Result runMergeSort(int[] arr, int k) {
        long totalTime = 0;
        int comparisons = 0;

        for (int i = 0; i < k; i++) {
            int[] copy = arr.clone();
            MergeSort tracker = new MergeSort();
            long start = System.nanoTime();
            tracker.mergeSort(copy, 0, copy.length - 1);
            long end = System.nanoTime();
            totalTime += (end - start);
            comparisons += tracker.getComparisons();
        }

        double avgTime = totalTime / 1e6 / k; // média em ms
        boolean sorted = isSorted(arr);
        return new Result(avgTime, comparisons / k, sorted);
    }

    // ============================
    // Run HeapSort
    // ============================
    static Result runHeapSort(int[] arr, int k) {
        long totalTime = 0;
        int comparisons = 0;

        for (int i = 0; i < k; i++) {
            int[] copy = arr.clone();
            HeapSort tracker = new HeapSort();
            long start = System.nanoTime();
            tracker.heapSort(copy);
            long end = System.nanoTime();
            totalTime += (end - start);
            comparisons += tracker.getComparisons();
        }

        double avgTime = totalTime / 1e6 / k; // média em ms
        boolean sorted = isSorted(arr);
        return new Result(avgTime, comparisons / k, sorted);
    }


    // ============================
    // Checar se está ordenado
    // ============================
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i-1] > arr[i]) return false;
        return true;
    }
}
