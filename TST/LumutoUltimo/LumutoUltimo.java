import java.util.Arrays;
import java.util.Scanner;

class QuickSort {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
        System.out.println(Arrays.toString(lista));
    }

    private static void particionar(int[] lista) {
        int pivot = lista[lista.length - 1];
        int i = lista.length - 1;
        for (int j = lista.length - 2; j >= 0; j--) 
            if (pivot < lista[j]) {
                swap(lista, --i, j);   
            }
        swap(lista, i, lista.length - 1);
    }

    private static int[] toIntArray(String[] entrada) {
        int[] result = new int[entrada.length];
        for (int i = 0; i < result.length; i++) 
            result[i] = Integer.parseInt(entrada[i]);
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] entrada = toIntArray(input.nextLine().split(" "));
        particionar(entrada);
        System.out.println(Arrays.toString(entrada));
    }
}