import java.util.Scanner;

class Down_N {
    private static void swap(int[] lista, int i1, int i2) {
        int sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void sort(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            boolean troca = false;
            int menor = i;
            for (int j = i + 1; j < lista.length; j++) 
                if (lista[menor] > lista[j]) {
                    menor = j;
                    troca = true;
                }

            if (troca) 
                swap(lista, i, menor);
        }
    }

    private static int[] toIntArray(String[] entrada) {
        int[] result = new int[entrada.length];
        for (int i = 0; i < result.length; i++) 
            result[i] = Integer.parseInt(entrada[i]);
        return result;
    }

    private static void showRange(int[] lista, int end) {
        for (int i = 0; i < end - 1; i++) 
            System.out.print(lista[i] + " ");
        System.out.println(lista[end - 1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] entrada = toIntArray(input.nextLine().split(" "));

        // Não usei nextInt para n precisar limpar o buffer
        int quantidade = Integer.parseInt(input.nextLine()); 

        sort(entrada);
        showRange(entrada, quantidade);

        input.close();
    }
}