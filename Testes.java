import java.util.Arrays;

public class Testes {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

	private static void insertionSort(int[] lista, int start, int end) {
		for (int i = start; i <= end; i++) {
			int key = lista[i];
			int count = i - 1;
			while (count >= 0 && lista[count] > key) {
				swap(lista, count, count + 1);
				count -= 1;
			}
			lista[count + 1] = key;
		}
	}

	private static void merge(int[] lista, int start, int mid, int end) {
		int[] sup = new int[lista.length];
		for (int i = 0; i < sup.length; i++) 
			sup[i] = lista[i];
		
		int indiceSupLeft = start;
		int indiceSupRight = mid + 1;
		int indiceArrayOriginal = start;

		while (indiceSupLeft <= mid && indiceSupRight <= end) 
			lista[indiceArrayOriginal++] =
				sup[indiceSupLeft] <= sup[indiceSupRight] ?
					sup[indiceSupLeft++] :
					sup[indiceSupRight++];
		
		while (indiceSupLeft <= mid)
			lista[indiceArrayOriginal++] = sup[indiceSupLeft++];

		while (indiceSupRight <= end)
			lista[indiceArrayOriginal++] = sup[indiceSupRight++];
	}

	// private static void mergeSort(int[] lista, int start, int end) {
	// 	if (start >= end) 
	// 		return;
		
	// 	int mid = (start + end) / 2;
	// 	mergeSort(lista, start, mid);
	// 	mergeSort(lista, mid + 1, end);
	// 	merge(lista, start, mid, end);
	// }

	private static void hybridMergeSort(int[] lista, int start, int end) {
        if (start >= end) 
            return;
        
        int size = end - start;
        if (size <= SIZE_LIMIT) {
            insertionSort(lista, start, end);
        } else {
            int mid = (end + start) / 2;
            hybridMergeSort(lista, start, mid);
			hybridMergeSort(lista, mid + 1, end);
			merge(lista, start, mid, end);
		}
	}

	public static void main(String[] args) {
        int[] array = { 4, 9, 3, 4, 0, 5, 1, 4 };
        hybridMergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
