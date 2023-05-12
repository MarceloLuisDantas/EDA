import java.util.Scanner;

public class TrimLinkedList {
    static int[] toIntArray(String[] lista) {
        int[] array = new int[lista.length];
        for (int i = 0; i < array.length; i++) 
            array[i] = Integer.parseInt(lista[i]);
        return array;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList lista = new LinkedList();

        lista.addAll(toIntArray(input.nextLine().split(" ")));
        int remover = Integer.parseInt(input.nextLine());
        
        while (remover > 0) {
            lista.removeFirst();
            lista.removeLast();
            remover -= 1;
        }

        System.out.println(lista.toString());
        input.close();
    }
}
