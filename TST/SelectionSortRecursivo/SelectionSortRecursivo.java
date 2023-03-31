import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
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

    private static void selectionSortRecursivo(int[] valores, int i) {
        if (i != valores.length - 1) {
            int sup = i;
            for (int j = i + 1; j < valores.length; j++) 
                if (valores[j] < valores[sup]) 
                    sup = j;

            if (sup != i) 
                swap(valores, i, sup);

            System.out.println(Arrays.toString(valores)); 
            selectionSortRecursivo(valores, i + 1);
        }
    }

    private static void selectionSortRecursivo(int[] valores) {
        if (valores.length >= 2) {
            int sup = 0;
            for (int j = 1; j < valores.length; j++) 
                if (valores[j] < valores[sup]) 
                    sup = j;

            if (sup != 0) 
                swap(valores, 0, sup);
            
            System.out.println(Arrays.toString(valores)); 
            selectionSortRecursivo(valores, 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] entrada = toIntArray(input.nextLine().split(" "));
        selectionSortRecursivo(entrada);
    }
}