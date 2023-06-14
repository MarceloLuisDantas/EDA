package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

import java.util.*;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter = 0;
	private int LRcounter = 0;
	private int RRcounter = 0;
	private int RLcounter = 0;

	public AVLCountAndFillImpl() { }

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance (BSTNode<T> node) {
		BSTNode<T> newRoot = null;

		int balance = calculateBalance(node);
		if (Math.abs(balance) > 1) {
			if (balance > 1) {
				if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
					newRoot = Util.rightRotation(node);
					LLcounter += 1;
				} else {
					newRoot = Util.doubleRightRotation(node);
					LRcounter += 1;
				}
			} else {
				if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
					newRoot = Util.leftRotation(node);
					RRcounter += 1;
				} else {
					newRoot = Util.doubleLeftRotation(node);
					RLcounter += 1;
				}
			}
		}

		if (getRoot().equals(node) && newRoot != null)
			root = newRoot;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		Set<T> filtrada = new TreeSet<>(Arrays.asList(order()));
		for (T t : array) 
			filtrada.add(t);
	
		array = (T[]) filtrada.toArray(new Comparable[0]);
		root = new BSTNode<>();
		int height = 0;
		while (fill(array, 0, array.length, height))
			height += 1;
	}

	private boolean fill(T[] array, int esquerda, int direita, int altura) {
		if (direita <= esquerda) 
			return false;

		int meio = esquerda + (direita - esquerda) / 2;
		if (altura == 0) {
			insert(array[meio]);
			return true;
		} 
			
		boolean result1 = fill(array, esquerda, meio, altura - 1);
		boolean	result2 = fill(array, meio + 1, direita, altura - 1);
		return result1 || result2;
	}
}