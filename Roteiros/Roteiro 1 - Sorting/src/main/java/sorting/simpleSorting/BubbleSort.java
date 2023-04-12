package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private void bubbleSort(T[] lista, int start, int end) {
        for(int i = start; i < end; i++) 
            for(int j = start; j < end - i; j++) 
                if(lista[j].compareTo(lista[j + 1]) > 0) 
                    swap(lista, j, j + 1);
    }

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		bubbleSort(array, leftIndex, rightIndex);
	}
}
