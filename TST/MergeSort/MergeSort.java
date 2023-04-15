import java.util.Scanner;

class MergeSort {
    private static void showRange(int[] lista, int start, int end) {
        System.out.print("[");
        for (int i = start; i < end; i++) 
            System.out.print(lista[i] + ", ");
        System.out.println(lista[end] + "]");
    }

    private static void merge(int[] lista, int left, int mid, int right) {
        int[] sup = new int[lista.length];
        for (int i = left; i <= right; i++) 
            sup[i] = lista[i];
        
        int indiceSupLeft = left;
        int indiceSupRight = mid + 1;
        int indiceArrayOriginal = left;

        while (indiceSupLeft <= mid && indiceSupRight <= right) {
            lista[indiceArrayOriginal++] = 
                sup[indiceSupLeft] <= sup[indiceSupRight] ?
                    sup[indiceSupLeft++] :
                    sup[indiceSupRight++];
        }
        
        while (indiceSupLeft <= mid)
            lista[indiceArrayOriginal++] = sup[indiceSupLeft++];

        while (indiceSupRight <= right) 
            lista[indiceArrayOriginal++] = sup[indiceSupRight++];

        showRange(lista, left, right);
    }
    
    private static void mergeSort(int[] lista, int left, int right) {
        showRange(lista, left, right);
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(lista, left, mid);
        mergeSort(lista, mid + 1, right);
        merge(lista, left, mid, right);
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
        mergeSort(entrada, 0, entrada.length - 1);
    }
}