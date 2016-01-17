package com.samy.leetcode.algorithm;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthofBinaryTree {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/minimum-depth-of-binary-tree/
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if (root.left != null)
			left = minDepth(root.left);
		if (root.right != null)
			right = minDepth(root.right);
		return Math.min(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
