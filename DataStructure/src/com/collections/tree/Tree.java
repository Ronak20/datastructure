package com.collections.tree;

public class Tree {

	public int x;
	public Tree l;
	public Tree r;

	public Tree(int x, Tree l, Tree r) {
		this.x = x;
		this.l = l;
		this.r = r;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Tree getL() {
		return l;
	}

	public void setL(Tree l) {
		this.l = l;
	}

	public Tree getR() {
		return r;
	}

	public void setR(Tree r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return String.valueOf(x);
	}

	// detailed tree string
	// @Override
	// public String toString() {
	// return "Tree [x=" + x + ", l=" + l + ", r=" + r + "]";
	// }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((l == null) ? 0 : l.hashCode());
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tree other = (Tree) obj;
		if (l == null) {
			if (other.l != null)
				return false;
		} else if (!l.equals(other.l))
			return false;
		if (r == null) {
			if (other.r != null)
				return false;
		} else if (!r.equals(other.r))
			return false;
		if (x != other.x)
			return false;
		return true;
	}
}
