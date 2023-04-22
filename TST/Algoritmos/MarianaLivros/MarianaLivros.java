import java.util.Arrays;
import java.util.Scanner;

class MarianaLivros {

    private static String toString(String[] lista) {
        String result = new String();
        for (String i : lista) 
            result += i + ", ";
        return result;
    }

    private static void swap(String[] lista, int i1, int i2) {
        String sup = lista[i1];
        lista[i1] = lista[i2];
        lista[i2] = sup;
    }

    private static void insertionSort(String[] lista, int i) {
        if (i != lista.length) {
            int menorIndice = i;
            for (int j = i; j < lista.length; j++) {
                if (lista[menorIndice].compareTo(lista[j]) >= 1)
                menorIndice = j;
            } 
            
            System.out.println(toString(lista));
            if (menorIndice != i) 
                swap(lista, i, menorIndice);

            insertionSort(lista, i + 1);
        } 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] entrada = "Deuses Americanos,Lugar Nenhum,Sandman,Crimes ABC,Carrie,O Pequeno Principe,Sherlock,Neuromance".split(",");            
        // String[] entrada = input.nextLine().split(",");
        insertionSort(entrada, 0);
    }
}