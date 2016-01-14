package com.samy.leetcode.algorithm;

public class BalancedBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/balanced-binary-tree/
	 */
	public boolean isBalanced(TreeNode root) {
		return depthOfBalancedTree(root) > 0;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description return -1 if it's not a balanced tree, or return its depth
	 * @reference
	 */
	private int depthOfBalancedTree(TreeNode root) {
		if (root == null)
			return 0;
		int l_depth = depthOfBalancedTree(root.left);
		if (l_depth < 0)
			return -1;
		int r_depth = depthOfBalancedTree(root.right);
		if (r_depth < 0)
			return -1;
		int diff = Math.abs(l_depth - r_depth);
		return diff <= 1 ? Math.max(l_depth, r_depth) + 1 : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree bt = new BalancedBinaryTree();
		int[] n = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, -1, -1, 5, 5 };
		TreeNode tn = TreeNode.constructABinaryTreeSampleByArray(n);
		//TreeNode.printBinaryTreeInorderTraversal(tn);
		System.out.println(bt.isBalanced(tn));
	}

}
