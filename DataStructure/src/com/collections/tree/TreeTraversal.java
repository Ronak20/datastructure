package com.collections.tree;

/**
 * Contains Tree traversal algorithms
 * 
 * @author Ronak
 *
 */
public class TreeTraversal {
	public void inOrder(Tree node) {
		if (node == null)
			return;

		inOrder(node.l);
		System.out.println(node.x);
		inOrder(node.r);
	}
}
