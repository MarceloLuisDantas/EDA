import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {
    private static void merge(Integer[] original, int inicio, int meio, int fim) {
        Integer[] sup = original.clone();
        
        int cursor = inicio;
        int i = inicio;
        int j = meio + 1;

        while (i <= meio && j <= fim) {
            if (sup[i] <= sup[j]) 
                original[cursor++] = sup[i++];           
            else 
                original[cursor++] = sup[j++];
        }

        while (i <= meio)
            original[cursor++] = sup[i++];

        while (j <= fim)
            original[cursor++] = sup[j++];

    }

    private static void mergeSort(Integer[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio + 1, fim);
            merge(lista, inicio, meio, fim);
        }
    }
    
    public static void main(String[] args) {
        Random rng = new Random();
        List<Integer> lista = new ArrayList<Integer>();
        while (true) {
            lista.add(rng.nextInt());
            mergeSort(lista.toArray(new Integer[lista.size()]), 0, lista.size() - 1);   
            if (lista.size() % 1000 == 0) 
                System.out.println('.');
        }
    }
}

