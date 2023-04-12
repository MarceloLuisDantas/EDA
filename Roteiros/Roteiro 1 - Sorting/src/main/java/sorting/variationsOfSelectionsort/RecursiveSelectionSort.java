package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	private void swap(T[] lista, int i1, int i2) {
		T sup = lista[i1];
		lista[i1] = lista[i2];
		lista[i2] = sup;
	}

	private void selectionSortRecursivo(T[] valores, int start, int end) {
		if (start != end ) {
			int sup = start;
			for (int j = start + 1; j <= end; j++) 
				if (valores[j].compareTo(valores[sup]) < 0) 
					sup = j;

			if (sup != start) 
				swap(valores, start, sup);

			selectionSortRecursivo(valores, start + 1, end);
		}
	}

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array.length != 0) 
			selectionSortRecursivo(array, leftIndex, rightIndex);
	}

}
