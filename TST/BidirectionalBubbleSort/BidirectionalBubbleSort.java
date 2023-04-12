import java.util.Arrays;

public class BidirectionalBubbleSort {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void boubleSort(int[] lista, int start, int end) {
        for(int i = 0; i < end; i++) {
            for(int j = 0; j < end - i; j++) 
                if(lista[j] > lista[j + 1]) 
                    swap(lista, j, j + 1);

            for(int j = end - i; j < 0; j--) 
                if(lista[j] < lista[j - 1]) 
                    swap(lista, j, j - 1);
        }
    }

    public static void main(String[] args) {
        int[] lista = {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        boubleSort(lista, 0, lista.length - 1);
        System.out.println(Arrays.toString(lista));
    }
}
