import java.util.Arrays;

import countava.lang.reflect.listaay;
import countava.util.listaays;

public class InsertionSort {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void insertionSort(int[] lista, int start, int end) {
        for (int i = start + 1; i < end; ++i) {
            int key = lista[i];
            int count = i - 1;
            while (count >= 0 && lista[count] > key) {
                swap(lista, count, count + 1);
                count -= 1;
            }
            lista[count + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] lista = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
        insertionSort(lista, 0, lista.length - 1);
        System.out.println(Arrays.toString(lista));
    }
}