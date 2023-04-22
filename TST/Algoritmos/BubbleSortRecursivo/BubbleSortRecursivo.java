import java.util.Arrays;

public class BubbleSortRecursivo {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void bubbleSort(int[] lista, int start, int end) {
		if (start >= end) 
			return;

		for(int j = start; j < end; j++) 
			if(lista[j] > lista[j + 1]) 
				swap(lista, j, j + 1);

		bubbleSort(lista, start, end - 1);
    }

    public static void main(String[] args) {
        int[] lista = {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        bubbleSort(lista, 0, lista.length - 1);
        System.out.println(Arrays.toString(lista));
    }
}