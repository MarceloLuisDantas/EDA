package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	private void print() {
		int sup = top;
		for (T i : array) {
			System.out.print(i + " ");
			sup -= 1;
			if (sup == -1)
				break;
		}
		System.out.println("");
	}

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()) 
			array[++top] = element;
		else 
			throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty())
			return array[top--];
		throw new StackUnderflowException();
	}

	public static void main(String[] args) {
		StackImpl<Integer> s1 = new StackImpl<Integer>(10);
		try {
			s1.push(4);
			s1.push(4);
			s1.push(4);
			s1.push(4);
			s1.push(4);
			s1.print();
			System.out.println(s1.pop());
			s1.print();
			System.out.println(s1.top());

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
