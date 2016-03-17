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
public class HouseRobberIII {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年3月17日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/house-robber-iii/
	 * @interpretation
	 */
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		int sub1 = rob(root.left) + rob(root.right);
		int sub2 = 0;
		if (root.left != null)
			sub2 += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			sub2 += rob(root.right.left) + rob(root.right.right);
		return Math.max(sub1, sub2 + root.val);
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年3月17日
	 * @author Jiupeng
	 * @description Time limit Exceeded
	 * @reference 
	 * @interpretation
	 */
	public int robTooSlow(TreeNode root) {
		if (root == null)
			return 0;
		int sub1 = rob(root.left) + rob(root.right);
		int sub2 = 0;
		if (root.left != null)
			sub2 += rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			sub2 += rob(root.right.left) + rob(root.right.right);
		return Math.max(sub1, sub2 + root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
