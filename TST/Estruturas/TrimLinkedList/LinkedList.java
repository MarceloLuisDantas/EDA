public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int value) {
        if (size == 0) { 
            head = new Node(value);
            tail = head; 
        } else {
            Node newNode = new Node(value);
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size += 1;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        head.previous = newNode;
        newNode.next = head;

        Node sup = head;
        head = newNode;
        newNode = sup;

        size += 1;
    }
    
    public void addAll(int[] valores) {
        for (int i : valores) 
            add(i); 
    }

    public int removeFirst() {
        int result = head.valor;
        head = head.next;
        head.previous = null;
        size -= 1;
        return result;
    }

    public int removeLast() {
        int result = tail.valor;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size -= 1;
        return result;
    }


    public int remove(int indice) {
        if (indice == size - 1)
            return removeLast();

        if (indice == 0)
            return removeFirst();

        Node sup = head;
        while (indice > 1) {
            sup = sup.next;
            indice -= 1;
        }
        int result = sup.valor;
        
        sup.next.previous = sup.previous;
        sup.previous.next = sup.next;
        
        size -= 1;
        return result;
    }

    public int get(int indice) {
        if (indice < 0 || indice >= size) 
            return 0;

        Node sup = head;
        while (indice > 1) {
            sup = sup.next;
            indice -= 1;
        }

        return sup.valor;
    }

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(size - 1);
    }

    public void insert(int valor, int indice) {
        if (indice == size) {
            add(valor);
        } else if (indice == 0) {
            addFirst(valor);
        } else {
            Node newNode = new Node(valor);
    
            Node sup = head;

            // 1 e não 0 pos assim fazendo com zero ele so vai para o while apos
            // o indice escolhido, e lidando com o indice anteior é mais facil
            // Ex Parando em 0 :- 
            //    Valor = 3 | Indice = 2 | [1 <- indice, 2, 4, 5] | indice -= 1
            //    Valor = 3 | Indice = 1 | [1, 2 <- inicio, 4, 5] | indice -= 1
            //    Valor = 3 | Indice = 0 | [1, 2, 4 <- inicio, 5] | indice -= 1
            //    Lista final = [1, 2, 4, 3, 5]
            //
            // Ex Parando em 1 :- 
            //    Valor = 3 | Indice = 2 | [1 <- indice, 2, 4, 5] | indice -= 1
            //    Valor = 3 | Indice = 1 | [1, 2 <- inicio, 4, 5] | indice -= 1
            //    Lista final = [1, 2, 3, 4, 5]
            while (indice != 1) {
                sup = sup.next;
                indice -= 1;
            }

            newNode.next = sup.next;
            newNode.previous = sup;

            sup.next.previous = newNode;
            sup.next = newNode;
            size += 1;
        }
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int len() {
        return this.size;
    }

    public String toString() {
        if (head == null) 
            return "Vazia";

        String result = new String();
        Node sup = head;
        while (sup != null) {
            result += (String.valueOf(sup.valor) + " ");
            sup = sup.next;
        }

        return result;
    }

    public int[] toArray() {
        int[] array = new int[size];

        Node sup = head;
        int count = 0;
        while (sup != null) {
            array[count++] = sup.valor;
            sup = sup.next;
        }
        
        return array;
    }
}
