
public class MergeSort {
	private int comparisons = 0;

    public int getComparisons() { return comparisons; }
	public static void mergeSort(int[] A, int p, int r) {
		if (p < r ) {
			// divisao por 2
			int q = (p + r)/ 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
    }
		
	public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        
        // separar subproblemas
        int[] Left = new int[n1+1];
        int[] Right = new int [n2 + 1];
        
        for (int i = 0; i < n1; i++) {
        	Left[i] = A[p + i];
        }
        
        for(int j = 0; j < n2; j++) {
        	Right[j] = A[q + 1 + j];
        	
        }
        Left[n1] = Integer.MAX_VALUE;
        Right[n2] = Integer.MAX_VALUE;
        int i = 0; int j =0;
        for (int k = p; k <=r; k++) {
        	if (Left[i] <= Right[j]) {
        		A[k] = Left[i]; 
        		i++;
        	}
        	else {
        		A[k] = Right[j]; j++;
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
