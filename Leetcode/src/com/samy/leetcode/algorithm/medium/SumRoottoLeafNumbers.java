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
public class SumRoottoLeafNumbers {

	private int sum = 0;

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê3ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 109 test cases, 1ms beats 28.93%
	 * @reference https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 * @interpretation
	 */
	public int sumNumbers(TreeNode root) {
		this.sum = 0;
		if (root != null)
			helper(root, 0);
		return this.sum;
	}

	private void helper(TreeNode root, int pre) {
		pre = pre * 10 + root.val;
		if (root.left == null && root.right == null)
			this.sum += pre;
		else {
			if (root.left != null)
				helper(root.left, pre);
			if (root.right != null)
				helper(root.right, pre);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
