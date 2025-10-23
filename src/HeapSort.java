public class HeapSort {
	private int comparisons = 0;

    public int getComparisons() { return comparisons; }
    // Função principal do Heap Sort
    public static void heapSort(int[] A) {
        int n = A.length;

        // 1️⃣ Construir o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        // 2️⃣ Extrair elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move o maior (raiz) para o final
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // Reorganiza o heap reduzido
            heapify(A, i, 0);
        }
    }

    // Função que mantém a propriedade de heap máximo
    public static void heapify(int[] A, int heapSize, int i) {
        int largest = i;       // Inicialmente, assume que o pai é o maior
        int left = 2 * i + 1;  // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Verifica se o filho da esquerda é maior que o pai
        if (left < heapSize && A[left] > A[largest])
            largest = left;

        // Verifica se o filho da direita é maior que o maior atual
        if (right < heapSize && A[right] > A[largest])
            largest = right;

        // Se o maior não for o pai, troca e chama heapify recursivamente
        if (largest != i) {
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;

            heapify(A, heapSize, largest);
        }
    }

    // Função para imprimir o array
    public static void printArray(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Testando o Heap Sort
    public static void main(String[] args) {
        int[] array = {4, 10, 3, 5, 1};

        System.out.println("Array original:");
        printArray(array);

        heapSort(array);

        System.out.println("Array ordenado:");
        printArray(array);
    }
}
