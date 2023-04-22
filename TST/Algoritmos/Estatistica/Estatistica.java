import java.util.Arrays;
import java.util.Scanner;

class Estatistica {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void particionar(int[] lista) {
        int index = 1;
        for (int i = 1; i < lista.length; i++) 
            if (lista[i] < lista[0]) 
                swap(lista, index++, i);
        swap(lista, 0, index - 1);
    }

    private static int estatistica(int[] lista) {
        int valor = lista[0];
        int menores = 1;
        for (int i : lista) 
            if (i < valor) 
                menores += 1;
        return menores;
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
        System.out.println(estatistica(entrada));   
        particionar(entrada);
    }
}