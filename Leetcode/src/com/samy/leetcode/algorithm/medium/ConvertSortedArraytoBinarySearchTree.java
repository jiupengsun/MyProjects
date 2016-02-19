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
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê2ÔÂ19ÈÕ
	 * @author Jiupeng
	 * @description 32 test cases, 1ms beats 7.65%
	 * @reference https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	 * @interpretation https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return heightBST(nums, 0, nums.length - 1);
	}

	private TreeNode heightBST(int[] nums, int st, int en) {
		if (st > en)
			return null;
		if (st == en)
			return new TreeNode(nums[st]);
		int mid = (st + en) >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = heightBST(nums, st, mid - 1);
		root.right = heightBST(nums, mid + 1, en);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
