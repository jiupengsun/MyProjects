package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {

	/**
	 * 
	 * @param root
	 * @param target
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 114 test cases, 3ms beats 41.57%
	 * @reference https://leetcode.com/problems/path-sum-ii/
	 * @interpretation
	 */
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		List<Integer> prePath = new ArrayList<Integer>();
		helper(path, prePath, root, target);
		return path;
	}

	private void helper(List<List<Integer>> path, List<Integer> prePath, TreeNode root, int target) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (target == root.val) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(prePath);
				tmp.add(root.val);
				path.add(tmp);
			}
		} else {
			target -= root.val;
			prePath.add(root.val);
			helper(path, prePath, root.left, target);
			helper(path, prePath, root.right, target);
			prePath.remove(prePath.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] trees = new int[] { 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1 };
		int target = 22;
		PathSumII ps = new PathSumII();
		ps.pathSum(TreeNode.constructABinaryTreeSampleByArray(trees), target);
	}

}
