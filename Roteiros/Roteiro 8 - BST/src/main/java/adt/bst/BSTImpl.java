package adt.bst;

import java.util.ArrayList;
import java.util.List;


public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		if (root == null) 
			return -1;

		return height(root) - 1;
	}

	private int height(BSTNode<T> node) {
		if (node == null)
			return 0;

		int alturaLeft = height((BSTNode<T>) node.getLeft());
		int alturaRight = height((BSTNode<T>) node.getRight());

		/* use the larger one */
		if (alturaLeft > alturaRight)
			return (alturaLeft + 1);
		else
			return (alturaRight + 1);
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> sup = root;
		while (true) {
			if (sup.getData().compareTo(element) == 0) 
				break;

			if (sup.getData().compareTo(element) > 0) 
				sup = (BSTNode<T>) sup.getLeft();
			else if (sup.getData().compareTo(element) < 0) 
				sup = (BSTNode<T>) sup.getRight();
			
			if (sup == null) 
				return new BSTNode<T>();
		}
		return sup;
	}

	private BSTNode<T> newNode(T element, BSTNode<T> parent) {
		return (BSTNode<T>) new BSTNode.Builder<T>()
			.data(element).left(null).right(null)
			.parent(parent).build();
	}

	@Override
	public void insert(T element) {
		if (root.isEmpty()) {
			root = newNode(element, null);
		} else {
			if (root.getData().compareTo(element) <= 0) {
				if (root.getRight() == null) 
					root.setRight(newNode(element, root));
				else 
					insert(element, (BSTNode<T>) root.getRight());
			} else {
				if (root.getLeft() == null) 
					root.setLeft(newNode(element, root));
				else 
					insert(element, (BSTNode<T>) root.getLeft());
			}
		}
	}

	private void insert(T element, BSTNode<T> node) { 
		if (node.getData().compareTo(element) < 0) {
			if (node.getRight() == null) 
				node.setRight(newNode(element, node));
			else 
				insert(element, (BSTNode<T>) node.getRight());
		} else {
			if (node.getLeft() == null) 
				node.setLeft(newNode(element, node));
			else 
				insert(element, (BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (root.isEmpty()) 
			return new BSTNode<T>();
		
		BSTNode<T> sup = root;
		while (true) {
			if (sup.getRight() == null)
				return sup;
			sup = (BSTNode<T>) sup.getRight();
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if (root.isEmpty()) 
			return new BSTNode<T>();
		return minimum(root);
	}

	public BSTNode<T> minimum(BSTNode<T> node) {
		while (true) {
			if (node.getLeft() == null)
				return node;
			node = (BSTNode<T>) node.getLeft();
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		
		if (node.getRight() != null) 
			return minimum((BSTNode<T>) node.getRight());
		
		if (node.getParent() != null) 
			return (BSTNode<T>) node.getParent();

		return node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) 
			return null;
		
		if (node.getLeft() != null) 
			return (BSTNode<T>) node.getLeft();

		while (true) {
			if (node.getParent() == null) 
				return null;

			node = (BSTNode<T>) node.getParent();
			if (node.getData().compareTo(element) < 0)
				return node;
		}
	}

	private boolean isLeft(BSTNode<T> node) {
		if (node == null || node.getParent().getLeft() == null) 
			return false;
		return (node.getParent().getLeft().getData() == node.getData());
	}

	public int 	filhos(BSTNode<T> node) {
		int count = 0;
		if (node.getLeft() != null)
			count += 1;

		if (node.getRight() != null)
			count += 1;
		return count;
	}

	private boolean isFolha(BSTNode<T> node) {
		return (
			node.getLeft() == null && 
			node.getRight() == null && 
			node.getParent() != null
		);
	}

	// private void removeFolhaEsquerda(BSTNode<T> node) {
	// 	node.getParent().setLeft(null);
	// }

	// private void removeFolhaDireita(BSTNode<T> node) {
	// 	node.getParent().setRight(null);
	// }

	private void removeFolha(BSTNode<T> node) {
		if (isLeft(node)) 
			node.getParent().setLeft(null);
		else 
			node.getParent().setRight(null);
	}

	private boolean umFilhoEsquerda(BSTNode<T> node) {
		return (node.getRight() == null && node.getLeft() != null);
	}

	private boolean umFilhoDireita(BSTNode<T> node) {
		return (node.getRight() != null && node.getLeft() == null);
	}

	private void removeNodeUmFilhoEsquerda(BSTNode<T> node) {
		if (isLeft(node)) 
			node.getParent().setLeft(node.getLeft());
		else 
			node.getParent().setRight(node.getLeft());
	}

	private void removeNodeUmFilhoDireita(BSTNode<T> node) {
		if (isLeft(node)) 
			node.getParent().setLeft(node.getRight());
		else 
			node.getParent().setRight(node.getRight());
	}

	private void removeNodeDoisFilhos(BSTNode<T> node) {
		T sup = node.getData();
		BSTNode<T> proximo = sucessor(sup);

		if (isLeft(node))
			node.getParent().getLeft().setData(proximo.getData());
		else 
			node.getParent().getRight().setData(proximo.getData());

		if (isLeft(proximo)) 
			proximo.getParent().getLeft().setData(sup);
		else 
			proximo.getParent().getRight().setData(sup);
	}

	private boolean isRaiz(BSTNode<T> node) {
		return node.getParent() == null;
	}

	private void removeRaiz() {
		if (root.getRight() != null) {
			T sup = root.getData();
			System.out.println(" - " + sup);
			BSTNode<T> proximo = sucessor(sup);
			System.out.println(" - " + proximo);
			System.out.println(" - " + proximo.getParent());
			System.out.println(root.getParent());
			root.setData(proximo.getData());

			if (isLeft(proximo)) 
				proximo.getParent().getLeft().setData(sup);
			else 
				proximo.getParent().getRight().setData(sup);


			if (umFilhoEsquerda(proximo))
				removeNodeUmFilhoEsquerda(proximo);
			else if (umFilhoDireita(proximo))
				removeNodeUmFilhoDireita(proximo);
			else if (filhos(proximo) == 2)
				removeNodeDoisFilhos(proximo);
			else 
				removeFolha(proximo);
				
		} else if (root.getLeft() != null) {
			root = (BSTNode<T>) root.getLeft();
			root.setParent(null);
		} else {
			root = new BSTNode<T>();
		}

		root.setParent(null);
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if (node != null) {
			// Caso 1 - O node a ser removido é a raiz
			if (isRaiz(node))
				removeRaiz();

			// Caso 2 - O node a ser removido é uma folha não raiz
			else if (isFolha(node)) 
				removeFolha(node);

			// Caso 3 - O node a ser removido tem 1 filho a esquerda
			else if (umFilhoEsquerda(node)) 
				removeNodeUmFilhoEsquerda(node);

			// Caso 4 - O node a ser removido tem 1 filho a direita
			else if (umFilhoDireita(node))
				removeNodeUmFilhoDireita(node);

			// Caso 5 - O node a ser removido tem 2 filhos
			else 
				removeNodeDoisFilhos(node);
		}
	}

	@Override
	public T[] 	preOrder() {
		List<T> lista = new ArrayList<T>();
		preOrder(lista, root);
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	public void preOrder(List<T> lista, BSTNode<T> node) {
		if (node != null) {
			lista.add(node.getData());
			preOrder(lista, (BSTNode<T>) node.getLeft());
			preOrder(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		List<T> lista = new ArrayList<T>();
		order(lista, root);
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	public void order(List<T> lista, BSTNode<T> node) {
		if (node != null) {
			order(lista, (BSTNode<T>) node.getLeft());
			lista.add(node.getData());
			order(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		List<T> lista = new ArrayList<T>();
		postOrder(lista, root);
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}

	public void postOrder(List<T> lista, BSTNode<T> node) {
		if (node != null) {
			postOrder(lista, (BSTNode<T>) node.getLeft());
			postOrder(lista, (BSTNode<T>) node.getRight());
			lista.add(node.getData());
		}
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
		if (node != null && !node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
