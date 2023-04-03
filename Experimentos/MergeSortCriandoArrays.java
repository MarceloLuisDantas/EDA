import java.util.Arrays;

public class MergeSortCriandoArrays {
    private static void merge(int[] original, int[] esquerda, int[] direita, int inicio) {
        int[] sup = new int[original.length];
        
        int cursor = 0;
        int indice_esquerda = 0;
        int indice_direita = 0;

        while (indice_esquerda < esquerda.length && indice_direita < direita.length) {
            if (esquerda[indice_esquerda] <= direita[indice_direita]) 
                sup[cursor++] = esquerda[indice_esquerda++];           
            else 
                sup[cursor++] = direita[indice_direita++];           
        }

        while (indice_esquerda < esquerda.length)
            sup[cursor++] = esquerda[indice_esquerda++];
        while (indice_direita < direita.length)
            sup[cursor++] = direita[indice_direita++];

        for (int i = 0; i < cursor; i++) 
            original[inicio + i] = sup[i];
    }

    private static void mergeSort(int[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio + 1, fim);
            
            int[] esquerda = Arrays.copyOfRange(lista, inicio, meio);
            int[] direita = Arrays.copyOfRange(lista, meio, fim);
            merge(lista, esquerda, direita, inicio);
        }
    }
    
    public static void main(String[] args) {
        int[] lista = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(lista, 0, lista.length - 1);
        System.out.println(Arrays.toString(lista));
    }
}
