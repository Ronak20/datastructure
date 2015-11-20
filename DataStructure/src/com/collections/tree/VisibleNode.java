package com.collections.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import com.collections.tree.comparator.TreeComparator;

public class VisibleNode {

	public int visibleNodes(Tree root) {
		int count = 1;// 1 for root
		Stack<Tree> stack = new Stack<>();
		Map<Tree, List<Integer>> map = new TreeMap<>(new TreeComparator());
		map.put(root, new ArrayList<Integer>(0));
		stack.push(root);

		while (!stack.isEmpty()) {
			Tree tree = (Tree) stack.pop();

			List<Integer> parentList = map.get(tree);
			map.put(tree, parentList);
			// System.out.print(" \n " + tree.x);

			if (tree.r != null) {
				stack.push(tree.r);
				List<Integer> rightParentList = new ArrayList<>(parentList);
				rightParentList.add(tree.x);
				map.put(tree.r, rightParentList);
			}

			if (tree.l != null) {
				stack.push(tree.l);
				List<Integer> leftParentList = new ArrayList<>(parentList);
				leftParentList.add(tree.x);
				map.put(tree.l, leftParentList);
			}

			Collections.sort(parentList);
			// System.out.println(" sorted parent nodes : " +
			// parentList.toString() + " for " + tree.x);

			if (parentList != null && parentList.size() > 0) {
				if (tree.x >= parentList.get(parentList.size() - 1)) {
					// System.out.println("Count increased for " + tree.x);
					count++;
				}
			}

			// System.out.println(" elem : " + tree.x);
			// System.out.println(" stack : " + stack.toString());
			// System.out.println(" map : " + map.toString());

		}

		return count;
	}

	public static void main(String... args) {
		VisibleNode sol = new VisibleNode();
		System.out.println(" Visible nodes for getTree1 : " + sol.visibleNodes(getTree1()));
		System.out.println(" Visible nodes for getTree2 : " + sol.visibleNodes(getTree2()));
		System.out.println(" Visible nodes for getTree3 : " + sol.visibleNodes(getTree3()));
	}

	/**
	 * from left to right layer 1,layer2,...,leaf nodes first left then right
	 * 
	 * 5 3 20 2 31 21 10 1 35
	 * 
	 * @return tree
	 */
	private static Tree getTree1() {
		Tree tree31 = new Tree(31, null, null);

		Tree tree2 = new Tree(2, tree31, null);

		Tree tree20 = new Tree(20, tree2, null);

		Tree tree21 = new Tree(21, null, null);

		Tree tree1 = new Tree(1, null, null);

		Tree tree3 = new Tree(3, tree20, tree21);

		Tree tree35 = new Tree(35, null, null);

		Tree tree10 = new Tree(10, tree1, tree35);

		Tree tree5 = new Tree(5, tree3, tree10);

		return tree5;
	}

	/**
	 * from left to right layer 1,layer2,...,leaf nodes first left then right 8
	 * 2 8 7
	 * 
	 * 6
	 * 
	 * @return
	 */
	private static Tree getTree2() {
		Tree tree8b = new Tree(8, null, null);

		Tree tree7 = new Tree(7, null, null);

		Tree tree2 = new Tree(2, tree8b, tree7);

		Tree tree6 = new Tree(6, null, null);

		Tree tree8a = new Tree(8, tree2, tree6);

		return tree8a;
	}

	/**
	 * 5 2 3
	 * 
	 * @return
	 */
	private static Tree getTree3() {
		Tree tree2 = new Tree(2, null, null);

		Tree tree3 = new Tree(3, null, null);

		Tree tree5 = new Tree(5, tree2, tree3);

		return tree5;
	}

}