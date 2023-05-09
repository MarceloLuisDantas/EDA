package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	private int proximaPosicao(int x) {
		if (x >= array.length - 1) return 0;
		return x + 1; 
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) throw new QueueOverflowException();
		head = proximaPosicao(head);
		array[head] = element;
		elements += 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) throw new QueueUnderflowException();
		T result = array[tail + 1];
		tail = proximaPosicao(tail);
		elements -= 1;
		return result;
	}

	@Override
	public T head() {
		return array[tail + 1];
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
