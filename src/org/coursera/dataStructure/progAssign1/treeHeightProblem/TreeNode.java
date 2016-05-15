package org.coursera.dataStructure.progAssign1.treeHeightProblem;

import java.util.HashSet;
import java.util.Set;

public class TreeNode implements Comparable<TreeNode>{
	
	TreeNode parent;
	Set<TreeNode> childs;
	int vertice;
	int height;
	
	public TreeNode(int index){
		this.vertice = index;
		childs = new HashSet<TreeNode>();
	}
	
	
	
	/**
	 * @return the vertice
	 */
	public int getVertice() {
		return vertice;
	}



	/**
	 * @param vertice the vertice to set
	 */
	public void setVertice(int vertice) {
		this.vertice = vertice;
	}



	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}



	/**
	 * @return the parent
	 */
	public TreeNode getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	/**
	 * @return the childs
	 */
	public Set<TreeNode> getChilds() {
		return childs;
	}
	/**
	 * @param childs the childs to set
	 */
	public void setChilds(Set<TreeNode> childs) {
		this.childs = childs;
	}
	
	public boolean addChild(TreeNode childNode){
		return this.childs.add(childNode);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertice;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (vertice != other.vertice)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return vertice+" [h: " + height + "]";
	}

	@Override
	public int compareTo(TreeNode o) {
		return 0;
	}
	
	

}