package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree () {
		return isBST() && isAVL();
	}
	
	private boolean isAVL () {
		return avlTree.isEmpty() || isAVL(avlTree.getRoot());
	}

	private boolean isAVL(BSTNode<T> node) {
		if (node.isEmpty())
			return true;

		if (Math.abs(this.avlTree.calculateBalance(node)) > 1)
			return false;

		return 
			this.isAVL((BSTNode<T>) node.getLeft())	&&
			this.isAVL((BSTNode<T>) node.getRight());
	}
}