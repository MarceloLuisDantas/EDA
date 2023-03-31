import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
    private static int[] toIntArray(String[] entrada) {
        int[] result = new int[entrada.length];
        for (int i = 0; i < result.length; i++) 
            result[i] = Integer.parseInt(entrada[i]);
        return result;
    }

    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void ordena(int[] lista) {
        int valor = lista[0];
        if (valor > lista[lista.length - 1]) {
            for (int i = 1; i < lista.length; i++) 
                swap(lista, i - 1, i);
        } else {
            for (int i = 1; i < lista.length; i++) {
                if (valor < lista[i]) {
                    for (int j = 1; j < i; j++) 
                        swap(lista, j - 1, j);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] lista = toIntArray(input.nextLine().split(" "));
        ordena(lista);
        System.out.println(Arrays.toString(lista));
    }
}