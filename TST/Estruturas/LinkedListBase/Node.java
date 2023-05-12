public class Node {
    protected Node next;
    protected Node previous;
    protected int valor; 

    public Node(int valor) {
        this.valor = valor;
        this.next = null;
        this.previous = null;
    }

    public String toString() {
        return String.valueOf(valor);
    }
}