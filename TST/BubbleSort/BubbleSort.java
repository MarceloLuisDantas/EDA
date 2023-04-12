import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void boubleSort(int[] lista) {
        for(int i = 0; i < lista.length - 1; i++) 
            for(int j = 0; j < lista.length - 1 - i; j++) 
                if(lista[j] > lista[j + 1]) 
                    swap(lista, j, j + 1);
    }
    
    public static void main(String[] args) {
        int[] lista = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
        boubleSort(lista);
        System.out.println(Arrays.toString(lista));
    }
}