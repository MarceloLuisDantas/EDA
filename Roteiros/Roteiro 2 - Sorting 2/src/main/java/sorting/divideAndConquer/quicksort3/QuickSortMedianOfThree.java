package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {
	private void ordenaPivot(T[] lista) {
		if (lista[0].compareTo(lista[1]) > 0 ) 
			swap(lista, 0, 1); 
		
		if (lista[1].compareTo(lista[2]) > 0 ) {
			swap(lista, 1, 2);
			if (lista[0].compareTo(lista[1]) > 0 ) 
				swap(lista, 0, 1);
		}
	}

	private int melhorPivot(T[] lista, int start, int end) {
		T[] pivots = (T[]) new Comparable[]{lista[start], lista[(start + end) / 2], lista[end]}; 
		ordenaPivot(pivots);

		if (pivots[1] == lista[start])
			return start;
		
		if (pivots[1] == lista[end])
			return end;

		return (start + end) / 2;
	}
	
	private void swap(T[] lista, int i1, int i2) {
        T sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

	private int partition(T[] lista, int start, int end) {
		swap(lista, start, melhorPivot(lista, start, end));
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
