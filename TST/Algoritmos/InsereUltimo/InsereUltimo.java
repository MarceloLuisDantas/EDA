import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
    private static void swap(int[] lista, int p1, int p2) {
        int sup = lista[p1];
        lista[p1] = lista[p2];
        lista[p2] = sup;
    }

    private static void ordena(int[] lista) {
        int ultimo = lista[lista.length - 1];
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > ultimo) {
                for (int j = lista.length - 1; j != i; j--) {
                    swap(lista, j, j - 1);
                }
                break;
            }
        }
    }
    
    private static int[] toIntArray(String[] valores) {
        int[] result = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            result[i] = Integer.parseInt(valores[i]);
        } 
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] valores = toIntArray(input.nextLine().split(" "));    
        ordena(valores);
        System.out.println(Arrays.toString(valores));
    }
}