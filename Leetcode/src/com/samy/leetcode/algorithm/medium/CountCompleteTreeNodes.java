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
public class CountCompleteTreeNodes {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年4月24日
	 * @author Jiupeng
	 * @description o(n) time complexity, TLE
	 * @reference https://leetcode.com/problems/count-complete-tree-nodes/
	 * @interpretation https://zhongyinzhang.wordpress.com/2015/06/13/count-complete-tree-nodes/
	 */
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年4月24日
	 * @author Jiupeng
	 * @description 18 test cases, 78ms beats 83.42%
	 * @reference https://leetcode.com/problems/count-complete-tree-nodes/
	 * @interpretation 
	 */
	public int countNodes2(TreeNode root) {
		int result = 0;
		while (root != null) {
			++result;
			int h = height(root);
			int hright = height(root.right);
			if (hright == h - 1) {
				result += (1 << (h - 1)) - 1;
				root = root.right;
			} else {
				result += (1 << (h - 2)) - 1;
				root = root.left;
			}
		}
		return result;
	}

	private int height(TreeNode root) {
		int height = 0;
		while (root != null) {
			++height;
			root = root.left;
		}
		return height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		System.out.println(i << -2);
	}

}
