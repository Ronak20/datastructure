package com.collections.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public void postOrder(Tree node) {
		if (node == null)
			return;

		postOrder(node.l);
		postOrder(node.r);

		System.out.println(node.x);
	}

	public void BFS(Tree tree) {
		Queue<Tree> q = new LinkedList<>();
		q.add(tree.l);
		q.add(tree.r);

		while (!q.isEmpty()) {
			Tree t = q.remove();

			System.out.println(t.x);
			if (t.l != null) {
				if (t.x < t.l.x) {
					q.add(t.l);
				}
			}

			if (t.r != null) {
				if (t.x < t.r.x) {
					q.add(t.r);
				}
			}

		}
	}

	public void DFS(Tree root) {
		Stack<Tree> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Tree tree = (Tree) stack.pop();
			System.out.print(" \n " + tree.x);

			if (tree.r != null) {
				stack.push(tree.r);
			}

			if (tree.l != null) {
				stack.push(tree.l);
			}

		}
	}

}
