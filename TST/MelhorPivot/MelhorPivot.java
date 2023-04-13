import java.util.Arrays;
import java.util.Scanner;

class MelhorPivot {
    public static int mediana(int[] values) {
        int mid = (values.length - 1) / 2;
        
        int[] sorted = {values[0], values[mid], values[values.length - 1]};
        Arrays.sort(sorted);
        
        if (sorted[1] == values[0]) 
            return values[0];

        if (sorted[1] == values[mid]) 
            return values[mid];

        return values[values.length - 1];
    }

    private static int melhorPivot(int[] lista, int i1, int i2) {
        int mid = mediana(lista);
        
        int dif1 = Math.abs(mid - lista[i1]);
        int dif2 = Math.abs(mid - lista[i2]);
        
        return (dif1 <= dif2) ? i1 : i2;
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