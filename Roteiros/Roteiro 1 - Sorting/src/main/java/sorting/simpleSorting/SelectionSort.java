package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private void selectionSort(T[] lista, int start, int end) {
        for (int i = start; i <= end; i++) {
            int sup = i;
            for (int j = i + 1; j <= end; j++) 
                if (lista[j].compareTo(lista[sup]) < 0)
                    sup = j;    
            
            if (sup != i) 
                swap(lista, i, sup);
        }
    }

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		selectionSort(array, leftIndex, rightIndex);
	}
}
