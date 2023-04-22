import java.util.Arrays;

public class Teste {
    private static int max(Integer[] lista) {
        int max = 0;
        for (int i : lista) 
            if (i > max) { max = i; }  
        return max;
    }

    private static int min(Integer[] lista) {
        int min = 0;
        for (int i : lista) 
            if (i < min) { min = i; }  
        return min;
    }

    private static int[] geraContagem(Integer[] lista) {
		int min = min(lista) * -1;
		int max = max(lista) + 1;

        int[] contagem = new int[min + max];
        for (int i : lista)  
            contagem[i + min] += 1;        

        for (int i = 1; i < contagem.length; i++) 
            contagem[i] += contagem[i - 1];
        
		System.out.println(Arrays.toString(contagem));
        return contagem;
    } 

    private static void countSort(Integer[] lista) {
		int min = min(lista) * -1;
        int[] contagem = geraContagem(lista);
        int[] result = new int[lista.length];
        for (int i = lista.length - 1; i >= 0; i--) {
            // Valor original no array na possição I
            int valor = lista[i]; 

            // Posição que devera ser ocupada no array ordenado
            int posCorreta = contagem[valor + min] - 1; 

            // Coloca o valor da lista original do indice I na sua possição correta
            result[posCorreta] = lista[i];

            contagem[valor + min] -= 1;
        }

        for (int i = 0; i < result.length; i++) 
            lista[i] = result[i];
    }
    
    public static void main(String[] args) {
        Integer[] lista = new Integer[] { 4, 9, 3, 0, 5, 1, -1 };
        countSort(lista);
        System.out.println(Arrays.toString(lista));
    }
}