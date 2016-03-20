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
	 * @description 124 test cases, 1ms
	 * @reference https://leetcode.com/problems/house-robber-iii/
	 * @interpretation https://www.hrwhisper.me/leetcode-house-robber-iii/
	 */
	public int robSample(TreeNode root) {
		return treeDP(root)[0];
	}

	private int[] treeDP(TreeNode root) {
		int[] dp = new int[2];
		if (root != null) {
			int[] dp_left = treeDP(root.left);
			int[] dp_right = treeDP(root.right);
			dp[1] = dp_left[0] + dp_right[0];
			dp[0] = Math.max(dp[1], dp_left[1] + dp_right[1] + root.val);
		}
		return dp;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年3月17日
	 * @author Jiupeng
	 * @description Time limit Exceeded
	 * @reference 
	 * @interpretation Actually, my solution is something similar with the sample one. At least we both use the tree DP
	 * but in the solution, I recurse the function too many times, while in the sample, it solves this problem wisely,
	 * instead, it uses an two-length array, the first element presents the value contains the root, and the second
	 * presents the value without the root.
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
