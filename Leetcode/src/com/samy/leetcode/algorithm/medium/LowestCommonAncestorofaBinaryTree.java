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
public class LowestCommonAncestorofaBinaryTree {

	/**
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 31 test cases, 13ms beats 23.45%
	 * @reference https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	 * @interpretation
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
