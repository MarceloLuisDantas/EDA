package sorting.divideAndConquer.hybridMergesort;

import javax.naming.SizeLimitExceededException;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

	private void insertionSort(T[] lista, int start, int end) {
		for (int i = start; i <= end; i++) {
			T key = lista[i];
			int count = i - 1;
			while (count >= 0 && lista[count].compareTo(key) > 0) {
				swap(lista, count, count + 1);
				count -= 1;
			}
			lista[count + 1] = key;
		}
	}

	private void merge(T[] lista, int start, int mid, int end) {
		T[] sup = (T[]) new Comparable[lista.length];
		for (int i = 0; i < sup.length; i++) 
			sup[i] = lista[i];
		
		int indiceSupLeft = start;
		int indiceSupRight = mid + 1;
		int indiceArrayOriginal = start;

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

	private void hybridMergeSort(T[] lista, int start, int end) {
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

	public void sort(T[] array, int leftIndex, int rightIndex) {
		hybridMergeSort(array, leftIndex, rightIndex);
	}
}
