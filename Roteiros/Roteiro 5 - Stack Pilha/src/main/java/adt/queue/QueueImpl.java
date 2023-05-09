package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (tail == -1) 
			return null;
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private T shiftLeft() {
		int sup = 0;
		T result = array[0]; 
		while (sup != tail - 1) 
			array[sup] = array[++sup];
		tail -= 1;
		return result;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) throw new QueueOverflowException();
		array[tail + 1] = element;
		tail += 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) throw new QueueUnderflowException();
		return shiftLeft();
	}

}
