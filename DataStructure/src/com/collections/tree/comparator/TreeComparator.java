package com.collections.tree.comparator;

import java.util.Comparator;

import com.collections.tree.Tree;

public class TreeComparator implements Comparator<Tree> {

	@Override
	public int compare(Tree arg0, Tree arg1) {
		return arg0.x - arg1.x;
	}

}
