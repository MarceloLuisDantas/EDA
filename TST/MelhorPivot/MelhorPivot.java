import java.util.Arrays;
import java.util.Scanner;

class MelhorPivot {
    // private static int[] maioresMenores(int[] lista, int valor) {
    //     int menores = 0;
    //     int maiores = 0;
    //     for (int i : lista) {
    //         if (i >= valor) 
    //             menores += 1;
    //         else 
    //             menores += 1;
    //     }
    //     return new int[]{menores, maiores};   
    // }

    // public static double quociente(double valor1, Double valor2) {
    //     if (valor1 < valor2) {
    //         double sup = valor2;
    //         valor2 = valor1;
    //         valor1 = sup;
    //     }
        
    //     if (valor2 == 0)
    //         return -1;

    //     return valor1 / valor2;
    // }

    public static int mediana(int[] values) {
        int mid = (values.length - 1) / 2;
        
        int[] sorted = {values[0], values[mid], values[values.length - 1]};
        Arrays.sort(sorted);
        
        if (sorted[1] == values[0]) 
            return 0;

        if (sorted[1] == values[mid]) 
            return mid;

        return values.length - 1;
    }

    public static int poss(int i) {
        if (i < 0) 
            return i * -1;
        return i;
    }

    private static int melhorPivot(int[] lista, int i1, int i2) {
        int mid = mediana(lista);
        
        int dif1 = poss(mid % lista[i1]);
        int dif2 = poss(mid % lista[i2]);

        return (dif1 < dif2) ? i1 : i2;
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
        int[] pivots = toIntArray(input.nextLine().split(" "));
        System.out.println(melhorPivot(entrada, pivots[0], pivots[1]));
    }
}