package adt.bst;

import adt.bt.BTNode;

/**
 * 
 * Performs consistency ations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
        return bst.isEmpty() || isBST(bst.getRoot());
	}

	private boolean isBST(BTNode<T> node) {
        if (node.isEmpty())
            return true;

        if (isLeft(node) && isRight(node))
            return isBST(node.getLeft()) &&
                   isBST(node.getRight());

        return false;
    }

    private boolean isLeft(BTNode<T> node) {
        return isLeft(node.getLeft(), node);
    }

    private boolean isLeft(BTNode<T> node, BTNode<T> root) {
        if (node.isEmpty())
            return true;

        if (node.getData().compareTo(root.getData()) < 0)
            return isLeft(node.getLeft(), root) &&
                   isLeft(node.getRight(), root);

        return false;
	}

    private boolean isRight(BTNode<T> node) {
        return isRight(node.getRight(), node);
    }

    private boolean isRight(BTNode<T> node, BTNode<T> root) {
        if (node.isEmpty())
            return true;

        if (node.getData().compareTo(root.getData()) > 0)
            return isRight(node.getLeft(), root) &&
                   isRight(node.getRight(), root);
                    
        return false;
    }

}