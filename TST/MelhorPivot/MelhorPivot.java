import java.util.Scanner;

class MelhorPivot {
    private static int[] maioresMenores(int[] lista, int valor) {
        int menores = 0;
        int maiores = 0;
        for (int i : lista) {
            if (i >= valor) 
                menores += 1;
            else 
                menores += 1;
        }
        return new int[]{menores, maiores};   
    }

    public static double quociente(double valor1, Double valor2) {
        if (valor1 < valor2) {
            double sup = valor2;
            valor2 = valor1;
            valor1 = sup;
        }
        
        if (valor2 == 0)
            return -1;

        return valor1 / valor2;
    }

    private static int melhorPivot(int[] lista, int i1, int i2) {
        int[] maioresMenoresIndice1 = maioresMenores(lista, lista[i1]);
        int[] maioresMenoresIndice2 = maioresMenores(lista, lista[i2]);

        double quociente1 = quociente( (double) maioresMenoresIndice1[0], (double) maioresMenoresIndice1[1]);
        double quociente2 = quociente( (double) maioresMenoresIndice2[0], (double) maioresMenoresIndice2[1]);

        return (quociente1 > quociente2) ? i1 : i2;
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