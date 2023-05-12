import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();
        System.out.println(lista.toString());

        lista.add(10);
        lista.add(11);
        lista.add(12);

        System.out.println(lista.toString());
        System.out.println(lista.removeLast());
        System.out.println(lista.toString());

        lista.add(12);
        
        System.out.println(lista.toString());
        System.out.println(lista.isEmpty());

        System.out.println("---");
        while (!lista.isEmpty()) {
            System.out.println(lista.toString());
            System.out.println(lista.isEmpty());
        
            lista.removeLast();
        }
        System.out.println("---");
        
        System.out.println(lista.isEmpty());
        System.out.println(lista.toString());

        lista.add(20);
        lista.add(21);
        lista.add(23);

        System.out.println(lista.toString());
        System.out.println(lista.get(0) + " " + lista.get(2));
        System.out.println(lista.get(-1) + " " + lista.get(3));

        lista.insert(24, 3);
        System.out.println(lista.toString());

        lista.insert(22, 2);
        System.out.println(lista.toString());

        lista.addFirst(19);
        lista.addFirst(18);
        System.out.println(lista.toString());
        System.out.println(lista.getFirst());
        System.out.println(lista.getLast());

        System.out.println(Arrays.toString(lista.toArray()));

        System.out.println(lista.remove(0));
        System.out.println(lista.remove(3));
        System.out.println(lista.toString());

        System.out.println(lista.toString());
        System.out.println("tamanho: " + (lista.len()));
        lista.addAll(new int[]{25, 26, 27, 28, 29});
        System.out.println(lista.toString());
        System.out.println("tamanho: " + (lista.len()));

        System.out.println(lista.removeFirst());
        System.out.println(lista.removeLast());
        System.out.println(lista.toString());
        System.out.println("tamanho: " + (lista.len()));
        
        lista.add(29);
        System.out.println(lista.toString());
        
        System.out.println(lista.len());
        lista.remove((lista.len() / 2) + 1);
        System.out.println(lista.toString());
    }
}
