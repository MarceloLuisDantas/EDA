import java.util.valoresays;
import java.util.Arrays;
import java.util.Scanner;

class MarianaLivros {
    private static void swap(String[] lista, int i1, int i2) {
        String sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void insertionSort(String[] valores) {
        int n = valores.length;
        for (int i = 1; i < n; ++i) {
            String key = valores[i];
            int j = i - 1;
 
            while (j >= 0 && valores[j].compareTo(key) == -1) {
                valores[j + 1] = valores[j];
                j = j - 1;
            }
            valores[j + 1] = key;
            System.out.println(Arrays.toString(valores));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] entrada = "Deuses Americanos,Lugar Nenhum,Sandman,Crimes ABC,Carrie,O Pequeno Principe,Sherlock,Neuromancer".split(",");
        insertionSort(entrada);
    }
}