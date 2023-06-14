package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 *  - insert
 *  - preOrder
 *  - postOrder
 *  - remove
 *  - height
 *  - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance (BSTNode<T> node) {
		if (node.isEmpty())
			return 0;

		int result = 
			height((BSTNode<T>) node.getLeft()) -
			height((BSTNode<T>) node.getRight());

		return result;
	}

	// AUXILIARY
	protected void rebalance (BSTNode<T> node) {
		BSTNode<T> newRoot = null;
		int balance = calculateBalance(node);

		if (Math.abs(balance) <= 1)
			return;

		if (balance > 1)
			if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0)
				newRoot = Util.rightRotation(node);
			else
				newRoot = Util.doubleRightRotation(node);
		else
			if (calculateBalance((BSTNode<T>) node.getRight()) <= 0)
				newRoot = Util.leftRotation(node);
			else
				newRoot = Util.doubleLeftRotation(node);

		if (getRoot().equals(node) && newRoot != null)
			root = newRoot;
	}

	// AUXILIARY
	protected void rebalanceUp (BSTNode<T> node) {
		if (node.getParent() == null) 
			return;
		
		rebalance((BSTNode<T>) node.getParent());
		rebalanceUp((BSTNode<T>) node.getParent());
	}

	@Override
	public void insert (T element) {
		if (element != null)
			insert(root, element);
	}

	private void insert (BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element); 
			node.setRight(newNode(node));
			node.setLeft(newNode(node));
		} else {
			if (element.compareTo(node.getData()) > 0)
				insert((BSTNode<T>) node.getRight(), element);
			else
				insert((BSTNode<T>) node.getLeft(), element);
		}
		rebalance(node);
	}

	@Override
	public void remove (T element) {
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
			BSTNode<T> node2 = node.getRight().isEmpty() 
				? (BSTNode<T>) node.getLeft() 
				: (BSTNode<T>) node.getRight();

			if (root.equals(node)) {
				root = node2;
				root.setParent(null);
			} else {
				node2.setParent(node.getParent());
				if (node.getParent().getLeft().equals(node))
					node.getParent().setLeft(node2);
				else
					node.getParent().setRight(node2);
			}
		} 

		else {
			T sucessor = sucessor(node.getData()).getData();
			remove(sucessor);
			node.setData(sucessor);
		}

		rebalanceUp(node);
	}
}