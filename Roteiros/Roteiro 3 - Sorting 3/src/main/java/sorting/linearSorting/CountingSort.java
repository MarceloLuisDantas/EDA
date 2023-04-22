package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	private static int max(Integer[] lista) {
        int max = 0;
        for (int i : lista) 
            if (i > max) 
                max = i;
        return max;
    }

    private static int[] geraContagem(Integer[] lista) {
        int[] contagem = new int[max(lista) + 1];
        for (int i : lista)  
            contagem[i] += 1;        

        for (int i = 1; i < contagem.length; i++) 
            contagem[i] += contagem[i - 1];
        
        return contagem;
    } 

    private static void countSort(Integer[] lista) {
        int[] contagem = geraContagem(lista);
        int[] result = new int[lista.length];
        for (int i = lista.length - 1; i >= 0; i--) {
            // Valor original no array na possição I
            int valor = lista[i]; 

            // Posição que devera ser ocupada no array ordenado
            int posCorreta = contagem[valor] - 1; 

            // Coloca o valor da lista original do indice I na sua possição correta
            result[posCorreta] = lista[i];

            contagem[lista[i]] -= 1;
        }

        for (int i = 0; i < result.length; i++) 
            lista[i] = result[i];
    }

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		countSort(array);
	}

}
