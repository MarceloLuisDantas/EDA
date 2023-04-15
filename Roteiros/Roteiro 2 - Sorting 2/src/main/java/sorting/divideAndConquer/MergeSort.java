package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private void merge(T[] lista, int start, int mid, int end) {
		T[] sup = (T[]) new Comparable[lista.length];
		for (int i = 0; i < sup.length; i++) 
			sup[i] = lista[i];
		
		int indiceSupLeft = start;
		int indiceSupRight = mid + 1;
		int indiceArrayOriginal = start;

		/*
		 * Versão mais compata utilizando ternariodo que seria escrito como 
		 * 
		 * 	while (i < leftLength && j < rightLength) {
		 * 		if (left[i].compareTo(right[j]) <= 0) {
		 * 			result[k] = left[i];
		 * 			i++;
		 * 		} else {
		 * 			result[k] = right[j];
		 * 			j++;
		 * 		}
		 * 		k++;
		 * 	}
		 */
		while (indiceSupLeft <= mid && indiceSupRight <= end) 
			lista[indiceArrayOriginal++] =
				sup[indiceSupLeft].compareTo(sup[indiceSupRight]) <= 0 ?
					sup[indiceSupLeft++] :
					sup[indiceSupRight++];
		
		while (indiceSupLeft <= mid)
			lista[indiceArrayOriginal++] = sup[indiceSupLeft++];

		while (indiceSupRight <= end)
			lista[indiceArrayOriginal++] = sup[indiceSupRight++];
	}

	private void mergeSort(T[] lista, int start, int end) {
		if (start >= end) 
			return;
		
		int mid = (start + end) / 2;
		mergeSort(lista, start, mid);
		mergeSort(lista, mid + 1, end);
		merge(lista, start, mid, end);
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		mergeSort(array, leftIndex, rightIndex);
	}
}
