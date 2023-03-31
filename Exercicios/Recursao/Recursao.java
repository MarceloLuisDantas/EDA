// Altor: Marcelo Dantas
 
public class Recursao {
    private static int soma(int x, int y) {
        if (y == 0) 
            return x; 
        return soma(x + 1, y - 1);
    }

    private static int pot(int base, int potencia) {
        if (potencia <= 0) 
            return 1; 
        return base * pot(base, potencia - 1);
    }

    private static boolean contains(int[] lista, int n) {
        if (lista[0] == n) 
            return true;
        return contains(lista, n, 1);
    }

    private static boolean contains(int[] lista, int n, int cursor) {
        if (cursor == lista.length)  
            return false; 

        if (lista[cursor] == n) 
            return true; 

        return contains(lista, n, cursor + 1);
    }

    private static int sum(int[] lista) {
        return lista[0] + sum(lista, 1);
    }

    private static int sum(int[] lista, int cursor) {
        if (cursor == lista.length - 1)  
            return lista[cursor]; 
        return lista[cursor] + sum(lista, cursor + 1);
    }

    private static int busca_binaria(int[] lista, int n) {
        int meio = lista.length / 2 ;
        if (n == lista[meio]) { return meio; } 
        
        if (n > lista[meio]) {
            return busca_binaria(lista, n, meio + 1, lista.length);
        } else {
            return busca_binaria(lista, n, 0, meio - 1);
        }
    }

    private static int busca_binaria(int[] lista, int n, int start, int end) {
        if (end < start) { return -1; }

        int meio = (end + start) / 2 ;
        if (n == lista[meio]) { return meio; } 
        
        if (n > lista[meio]) {
            return busca_binaria(lista, n, meio + 1, end);
        } else {
            return busca_binaria(lista, n, start, meio - 1);
        }
    } 

    public static void main(String[] args) {
        System.out.println(soma(10, 10));    
        System.out.println(pot(2, 4));    

        int[] lista = {1, 2, 3, 4, 5, 6};
        System.out.println(contains(lista, 6));
        System.out.println(sum(lista));
        System.out.println(busca_binaria(lista, 6));
        System.out.println(busca_binaria(lista, 3));
        System.out.println(busca_binaria(lista, 1));
    }
}