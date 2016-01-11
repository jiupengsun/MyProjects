package com.samy.leetcode.algorithm;

public class InvertABinaryTree {

	/**
	 * 
	 * @param root
	 * @return 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/invert-binary-tree/
	 */
	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftChild = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(leftChild);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(6);
		root = invertTree(root);
		System.out.println(root.val);
	}

}
