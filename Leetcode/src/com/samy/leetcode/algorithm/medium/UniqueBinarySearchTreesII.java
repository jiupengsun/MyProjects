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
public class UniqueBinarySearchTreesII {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê3ÔÂ29ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/unique-binary-search-trees-ii/
	 * @interpretation
	 */
	public List<TreeNode> generateTrees(int n) {
		List<List<TreeNode>> treeList = new ArrayList<List<TreeNode>>();
		treeList.add(new ArrayList<TreeNode>());
		for (int i = 1; i <= n; ++i) {
			List<TreeNode> trees = new ArrayList<TreeNode>();
			TreeNode root = new TreeNode(i);
			for (int j = 0; j < i - 1; ++j) {

			}
		}
		return treeList.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII ubii = new UniqueBinarySearchTreesII();
		ubii.generateTrees(3);
	}

}
