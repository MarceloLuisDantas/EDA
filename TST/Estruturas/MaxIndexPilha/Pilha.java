import java.util.Scanner;

class Pilha {
    private int[] valores;
    private int capacidade;
    private int cursor;

    public Pilha(int len) {
        this.valores = new int[len];
        this.capacidade = len;
        this.cursor = -1;
    }

    public boolean isEmpty() {
        return cursor == -1;
    }

    public boolean isFull() {
        return cursor == capacidade - 1;
    }

    public int size() {
        return cursor + 1;
    }

    public int peek() {
        return valores[cursor];
    }

    public void push(int valor) {
        if (!isFull())
            valores[++cursor] = valor;
    }

    public int pop() {
        if (!isEmpty()) {
            int result = peek();
            cursor -= 1;
            return result;
        }
        System.out.println("Erro durante Pop");
        System.exit(-1);
        return 1;
    }

    public void show() {
        if (!isEmpty()) {
            Pilha sup = new Pilha(cursor + 1);
            while (!this.isEmpty()) 
                sup.push(this.pop());
                
            while (!sup.isEmpty()) {
                System.out.println(sup.peek());
                this.push(sup.pop());
            }
        }
    }

    private int busca(int limite) {
        Pilha sup = new Pilha(this.cursor + 1);
        int maior = 0;
        int cop = limite;
        while (limite >= 0) {
            int valor = this.pop();
            if (valor > maior)
                maior = valor;
            sup.push(valor);
            limite -= 1;
        }

        while (cop >= 0) {
            this.push(sup.pop());
            cop -= 1;
        }
        
        return maior;
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
        // int[] entrada = {8, 2, 33, 4, 1, 5, 9, 21};
        Pilha p = new Pilha(entrada.length);
        for (int i : entrada)
            p.push(i);

        int limiteBusca = input.nextInt();
        System.out.println(p.busca(limiteBusca));
    }
}
