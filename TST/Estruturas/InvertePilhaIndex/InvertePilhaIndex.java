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
            while (!this.isEmpty()) {
                System.out.println(this.peek());
                sup.push(this.pop());
            }
                
            while (!sup.isEmpty()) 
                this.push(sup.pop());
        }
    }

    private void inverte(int limite) {
        Pilha sup1 = new Pilha(this.cursor + 1);
        Pilha sup2 = new Pilha(this.cursor + 1);

        int cop = limite;
        while (limite >= 0) {
            sup1.push(this.pop());
            limite -= 1;
        } limite = cop;

        while (limite >= 0) {
            sup2.push(sup1.pop());
            limite -= 1;
        } limite = cop;

        while (limite >= 0) {
            this.push(sup2.pop());
            limite -= 1;
        }
    }

    private static int[] toIntArray(String[] entrada) {
        int[] result = new int[entrada.length];
        for (int i = 0; i < result.length; i++)
            result[i] = Integer.parseInt(entrada[i]);
        return result;
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pilha p = new Pilha(Integer.parseInt(input.nextLine()));

        int[] entrada = toIntArray(input.nextLine().split(" "));
        // int[] entrada = {8, 2, 1, 3, 0, 7, 2, 90, 12, 74};
        for (int i : entrada)
            p.push(i);

        int limite = input.nextInt();
        // int limite = 6;
        System.out.println("-");
        p.inverte(limite);
        p.show();
    }
}
