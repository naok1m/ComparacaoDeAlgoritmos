
public class MergeSort {

	public static void mergeSort(int[] A, int p, int r) {
        if (p < r) { // enquanto o subarray tiver mais de 1 elemento
            int q = (p + r) / 2;      // ponto do meio
            mergeSort(A, p, q);       // ordena a metade esquerda
            mergeSort(A, q + 1, r);   // ordena a metade direita
            merge(A, p, q, r);        // junta as duas metades
        }
    }
		
	public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1; // tamanho da metade esquerda
        int n2 = r - q;     // tamanho da metade direita

        int[] L = new int[n1 + 1]; // +1 para o sentinela
        int[] R = new int[n2 + 1];

        // Copiando elementos para L
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        // Copiando elementos para R
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + 1 + j];
        }

        // Sentinelas (infinito) para simplificar o merge
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        // Merge das duas metades
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    // Função para imprimir o array
    public static void printArray(int[] A) {
        for (int num : A) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Testando o Merge Sort
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array original:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        printArray(array);
    }

}
