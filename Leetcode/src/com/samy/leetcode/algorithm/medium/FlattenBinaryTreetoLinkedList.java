package com.samy.leetcode.algorithm.medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreetoLinkedList {

	/**
	 * 
	 * @param root
	 * 2016Äê3ÔÂ28ÈÕ
	 * @author Jiupeng
	 * @description 225 test cases, 1ms beats 34.42%
	 * @reference https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 * @interpretation
	 */
	public void flatten(TreeNode root) {
		helper(root);
	}

	private TreeNode helper(TreeNode root) {
		if (root == null || root.left == null && root.right == null)
			return root;
		TreeNode left = helper(root.left);
		TreeNode right = helper(root.right);
		root.left = null;
		root.right = left;
		TreeNode r = root;
		while (r.right != null)
			r = r.right;
		r.right = right;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
