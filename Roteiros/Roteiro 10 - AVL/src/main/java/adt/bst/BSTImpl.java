package adt.bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<>();
	}

	public BSTNode<T> getRoot() {
		return root;
	}

	private boolean maiorQue(T e1, T e2) {
		return e1.compareTo(e2) > 0;
	}
	
	private boolean maiorIgual(T e1, T e2) {
		return e1.compareTo(e2) >= 0;
	}

	private boolean menorQue(T e1, T e2) {
		return e1.compareTo(e2) < 0;
	}

	private boolean menorIgual(T e1, T e2) {
		return e1.compareTo(e2) <= 0;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	public int height(BSTNode<T> node) {
		int result = -1;

		if (node.isEmpty())
			return result;

		result = 1 + Math.max(
			height((BSTNode<T>) node.getLeft()),
			height((BSTNode<T>) node.getRight())
		);

		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element == null)
			return new BSTNode<>();
		return search(root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		if (node.isEmpty() || node.getData().equals(element))
			return node;

		if (maiorQue(element, node.getData()))
			return search((BSTNode<T>) node.getRight(), element);

		return search((BSTNode<T>) node.getLeft(), element);
	}

	protected BSTNode<T> newNode(BSTNode<T> parent) {
		return new BSTNode.Builder<T>().parent(parent).build();
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(root, element);
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setRight(newNode(node));
			node.setLeft(newNode(node));
		} else {
			if (maiorQue(element, node.getData()))
				insert((BSTNode<T>) node.getRight(), element);
			else
				insert((BSTNode<T>) node.getLeft(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty())
			return null;
		return maximum(root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight().isEmpty()) 
			return node;
		return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty())
			return null;
		return minimum(root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) 
			return node;
		return maximum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty())
			return null;

		if (!node.getRight().isEmpty())
			node = minimum((BSTNode<T>) node.getRight());
		else
			node = sucessor(node, element);
		
		if (node == null || node.isEmpty())
			return null;
		return node;
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		if (node != null && menorIgual(node.getData(), element)) 
			return sucessor((BSTNode<T>) node.getParent(), element);
		return node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty())
			return null;

		if (!node.getLeft().isEmpty())
			node = maximum((BSTNode<T>) node.getLeft());
		else
			node = predecessor(node, element);

		if (node == null || node.isEmpty()) 
			return null;
		return node;
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		if (node != null && maiorIgual(node.getData(), element)) 
			return predecessor((BSTNode<T>) node.getParent(), element);
		return node;
	}

	@Override
	public void remove(T element) {
		if (element == null) 
			return;

		BSTNode<T> node = search(element);
		if (node.isEmpty()) 
			return;

		if (node.isLeaf()) { 
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} 
		
		else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) { 
			BSTNode<T> filho = node.getRight().isEmpty() 
				? (BSTNode<T>) node.getLeft() 
				: (BSTNode<T>) node.getRight();

			if (root.equals(node)) {
				root = filho;
				root.setParent(null);
			} else {
				filho.setParent(node.getParent());
				if (node.getParent().getLeft().equals(node))
					node.getParent().setLeft(filho);
				else
					node.getParent().setRight(filho);
			}
		} 
		
		else {
			T sucessor = sucessor(node.getData()).getData();
			remove(sucessor);
			node.setData(sucessor);
		}
	}

	@Override
	public T[] preOrder() {
		List<T> lista = new ArrayList<T>();
		return preOrder(root, lista);
	}

	private T[] preOrder(BSTNode<T> node, List<T> lista) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			preOrder((BSTNode<T>) node.getLeft(), lista);
			preOrder((BSTNode<T>) node.getRight(), lista);
		}

		return (T[]) lista.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		List<T> lista = new ArrayList<T>();
		return order(root, lista);
	}

	private T[] order(BSTNode<T> node, List<T> lista) {
		if (!node.isEmpty()) {
			order((BSTNode<T>) node.getLeft(), lista);
			lista.add(node.getData());
			order((BSTNode<T>) node.getRight(), lista);
		}

		return (T[]) lista.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		List<T> lista = new ArrayList<T>();
		return postOrder(root, lista);
	}

	private T[] postOrder(BSTNode<T> node, List<T> lista) {
		if (!node.isEmpty()) {
			postOrder((BSTNode<T>) node.getLeft(), lista);
			postOrder((BSTNode<T>) node.getRight(), lista);
			lista.add(node.getData());
		}

		return (T[]) lista.toArray(new Comparable[0]);
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}