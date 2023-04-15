package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

	private int partition(T[] lista, int start, int end) {
		int indice = start;
		for (int i = indice + 1; i <= end; i++) 
			if (lista[start].compareTo(lista[i]) >= 0)
				swap(lista, ++indice, i);
		swap(lista, start, indice);
		return indice;
	}

	private void quickSort(T[] lista, int start, int end) {
		if (start < end) {
			int lastPivot = partition(lista, start, end);
			quickSort(lista, start, lastPivot - 1);
			quickSort(lista, lastPivot + 1, end);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		quickSort(array, leftIndex, rightIndex);
	}
}
