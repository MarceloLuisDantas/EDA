import java.util.Arrays;
import java.util.Scanner;

class Counting {
    private static void showArray(int[] lista) {
        for (int i : lista) 
            System.out.print(i + " ");
        System.out.println();
    }

    private static void countingSort(int[] lista, int max) {
        int[] contagem = new int[max + 1];        
        for (int i : lista) {
            contagem[i] += 1;
            showArray(contagem);
        }

        for (int i = 1; i < contagem.length; i++) {
            contagem[i] += contagem[i - 1];
        }

        System.out.print("Cumulativa do vetor de contagem - ");
        showArray(contagem);
        
        int[] copia = new int[lista.length];
        for (int i = 0; i < copia.length; i++) 
            copia[i] = lista[i];
    
        for (int i = lista.length - 1; i >= 0; i--) {
            lista[contagem[copia[i]] - 1] = copia[i];
            contagem[copia[i]] -= 1;
        }

        showArray(contagem);
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
        int max = input.nextInt();
        countingSort(entrada, max);
        showArray(entrada);
    }
}