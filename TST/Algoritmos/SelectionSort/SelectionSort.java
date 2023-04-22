import java.util.Arrays;
import java.util.Scanner;

class SelectionSort {
    private static int[] toIntArray(String[] valores) {
        int[] result = new int[valores.length];
        for (int i = 0; i < result.length; i++) 
            result[i] = Integer.parseInt(valores[i]);
        return result;
    }

    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void selectionSort(int[] lista, int start, int end) {
        for (int i = start; i < end; i++) {
            int sup = i;
            for (int j = i + 1; j < end; j++) 
                if (lista[j] < lista[sup])
                    sup = j;    
            
            if (sup != i) 
                swap(lista, i, sup);
        }
    }

    public static void main(String[] args) {
        int[] entrada = new int[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
        Scanner input = new Scanner(System.in);
        // int[] entrada = toIntArray(input.nextLine().split(" "));
        selectionSort(entrada, 0, entrada.length - 1);
        System.out.println(Arrays.toString(entrada));
    }
}