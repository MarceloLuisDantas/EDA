package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

	// Eu não entendi bem o que a questão estava pedindo, 
	// então eu fiz o que acredito estar certo
    private void bidirectionalBoubleSort(T[] lista, int start, int end) {
        for(int i = 0; i < end; i++) {
            for(int j = 0; j < end - i; j++) 
                if(lista[j].compareTo(lista[j + 1]) >= 0) 
                    swap(lista, j, j + 1);

            for(int j = end - i; j < 0; j--) 
                if(lista[j].compareTo(lista[j - 1]) < 0) 
                    swap(lista, j, j - 1);
        }
    }

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		bidirectionalBoubleSort(array, leftIndex, rightIndex);
	}
}
