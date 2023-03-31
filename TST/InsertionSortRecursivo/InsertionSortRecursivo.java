import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
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

    private static void insertionSortRecursivo(int[] lista, int i) {
        int sup = lista[i];
        int count = i;
        while (count != 0) {
            if (sup < lista[count - 1]) {
                swap(lista, count, count - 1);
            }
            count -= 1;
        }
        System.out.println(Arrays.toString(lista));
        
        if (i != lista.length - 1) 
            insertionSortRecursivo(lista, i + 1);
    }

    private static void insertionSortRecursivo(int[] lista) {
        if (lista.length > 1) {
            if (lista[1] < lista[0]) 
                swap(lista, 1, 0);
            System.out.println(Arrays.toString(lista));

            if (lista.length > 2) 
                insertionSortRecursivo(lista, 2);
        } 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] lista = toIntArray(input.nextLine().split(" "));
        insertionSortRecursivo(lista);
    }
}