package adt.bt;

import adt.bst.BSTNode;

public class Util {
	public static <T extends Comparable<T>> BSTNode<T> leftRotation (BSTNode<T> node) {
		BSTNode<T> sup = (BSTNode<T>) node.getRight();

		node.setRight(sup.getLeft());
		sup.setLeft(node);

		sup.setParent(node.getParent());
		node.setParent(sup);
		node.getRight().setParent(node);

		if (sup.getParent() != null)
			if (sup.getParent().getRight().equals(node))
				sup.getParent().setRight(sup);
			else
				sup.getParent().setLeft(sup);

		return sup;
	}

	public static <T extends Comparable<T>> BSTNode<T> rightRotation (BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

		node.setLeft(pivot.getRight());
		pivot.setRight(node);

		pivot.setParent(node.getParent());
		node.setParent(pivot);
		node.getLeft().setParent(node);

		if (pivot.getParent() != null)
			if (pivot.getParent().getLeft().equals(node))
				pivot.getParent().setLeft(pivot);
			else
				pivot.getParent().setRight(pivot);

		return pivot;
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleLeftRotation (BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		return leftRotation(node);
	}

	public static <T extends Comparable<T>> BSTNode<T> doubleRightRotation (BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		return rightRotation(node);
	}
}