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
	 * @param sum
	 * @return
	 * 2016Äê4ÔÂ6ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/path-sum-ii/
	 * @interpretation
	 */
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		List<List<Integer>> path = new ArrayList<List<Integer>>();
		List<Integer> prePath = new ArrayList<Integer>();
		helper(path, prePath, root, target);
		return path;
	}

	private void helper(List<List<Integer>> path, List<Integer> prePath,
			TreeNode root, int target) {
		if (root.left == null) {
			if (target == 0 && prePath.size() > 0) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.addAll(prePath);
				path.add(tmp);
			}
		} else {
			if (target - root.val >= 0) {
				target -= root.val;
				prePath.add(root.val);
				helper(path, prePath, root.left, target);
				helper(path, prePath, root.right, target);
				prePath.remove(prePath.size() - 1);
			}
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
