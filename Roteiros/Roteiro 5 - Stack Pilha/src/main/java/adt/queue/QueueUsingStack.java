package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		try {
			stack1.push(element);
		} catch (Exception e) {
			throw new QueueOverflowException();
		}		
	}

	private void transferir(Stack s1, Stack s2) throws QueueUnderflowException {
		try {
			while (!s1.isEmpty()) 
				s2.push(s1.pop());
		} catch (Exception e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) { throw new QueueUnderflowException(); }
		try {
			transferir(stack1, stack2);
			T result = stack2.pop();
			transferir(stack2, stack1);
			return result;
		} catch (Exception e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		try {
			transferir(stack1, stack2);	
			T result = stack2.top();
			transferir(stack2, stack1);			
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
