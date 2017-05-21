package com.jun.树;

//简单实现一个二叉查询树
//http://www.jianshu.com/p/230e6fde9c75

public class MyBinSearchTree<E extends Comparable<E>> {

	// 根
	private TreeNode<E> root;

	// 默认构造函数
	public MyBinSearchTree() {
	}

	// 二叉查找树的搜索
	public boolean search(E e) {

		TreeNode<E> current = root;
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

	// 二叉查找树的插入
	public boolean insert(E e) {

		// 如果之前是空二叉树 插入的元素就作为根节点
		if (root == null) {
			root = createNode(e);
		} else {
			// 否则就从根节点开始遍历 直到找到合适的父节点
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}
			// 插入
			if (e.compareTo(parent.element)<0){
				parent.left=createNode(e);
			} else if (e.compareTo(parent.element)>0){
				parent.right = createNode(e);
			}

		}
		return true;
	}

	// 创建新节点
	protected TreeNode<E> createNode(E e) {
		return new TreeNode(e);
	}

}

// 二叉树节点
class TreeNode<E extends Comparable<E>>  {
	E element;
	TreeNode<E> left;
	TreeNode<E> right;

	TreeNode(E e) {
		this.element = e;
	}
}
