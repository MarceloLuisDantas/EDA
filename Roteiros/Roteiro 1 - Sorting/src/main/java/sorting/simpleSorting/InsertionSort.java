package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private void insertionSort(T[] lista, int start, int end) {
		for (int i = start + 1; i <= end; ++i) {
            T key = lista[i];
            int count = i - 1;
            while (count >= 0 && lista[count].compareTo(key) >= 0) {
                swap(lista, count, count + 1);
                count -= 1;
            }
            lista[count + 1] = key;
        }
    }

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		insertionSort(array, leftIndex, rightIndex);
	}
}
