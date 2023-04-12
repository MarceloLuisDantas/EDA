import java.util.Arrays;
import java.util.Scanner;

class QuickSort {
    private static void showArray(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) 
            System.out.print(lista[i] + " ");
        System.out.println(lista[lista.length - 1]);
    }

    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static int particionar(int[] lista, int left, int end) {
        int i = left;
        for (int j = left + 1; j <= end; j++) 
            if (lista[left] >= lista[j]) 
                swap(lista, ++i, j);
        swap(lista, i, left);
        showArray(lista);
        return i;
    }

    private static void quickSort(int[] lista, int left, int right) {
        if (left < right) {
            int lastPivot = particionar(lista, left, right);
            quickSort(lista, left, lastPivot - 1);
            quickSort(lista, lastPivot + 1, right);
        }
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
        quickSort(entrada, 0, entrada.length - 1);
    }
}