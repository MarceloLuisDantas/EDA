import java.util.Arrays;
import java.util.Scanner;

class Move_N {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
        System.out.println(Arrays.toString(lista));
    }

    private static void moveBack(int[] lista, int indice) {
        while (true) {
            swap(lista, indice, --indice);
            if (indice == 0 || lista[indice - 1] < lista[indice])  
                return;
        }
    }

    private static void sort(int[] lista) {
        for (int i = 1; i < lista.length; i++) 
            if (lista[i - 1] > lista[i]) 
                moveBack(lista, i);
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
        sort(entrada);
    }    
}