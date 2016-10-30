package com.samy.leetcode.algorithm.easy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {

	/**
	 * 
	 * @param root
	 * @param sum
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/path-sum/
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (root.val == sum)
				return true;
			return false;
		}
		return hasPathSum(root.left, sum - root.val) ? true : hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
