package com.collections.tree;

public class MainTree {

	public static void main(String[] args) {
		Tree treeA = getTree1();
		Tree treeB = getTree2();
		Tree treeC = getTree3();
		
		MainTree main = new MainTree();
		main.inOrder(treeA);
		main.inOrder(treeB);
		main.inOrder(treeC);

	}
	
	public void inOrder(Tree node)
	{
		if(node == null)
			return;
		
		inOrder(node.l);
		System.out.println(node.x);
		inOrder(node.r);
	}
	
	/**
	 * from left to right layer 1,layer2,...,leaf nodes 
	 * first left then right
	 * 
	 * 5
	 * 	 3
	 * 	   20
	 *        2
	 *          31
	 *     21   	
	 * 	 10
	 *     1
	 *     35
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
	 * from left to right layer 1,layer2,...,leaf nodes 
	 * first left then right
	 * 8
	 *   2
	 *     8
	 *     7
	 *   
	 *   6
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
	 * 5
	 *  2
	 *  3
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
