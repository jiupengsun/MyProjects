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
	 * 2016年3月29日
	 * @author Jiupeng
	 * @description 9 test cases, 3ms beats 35.36%
	 * @reference https://leetcode.com/problems/unique-binary-search-trees-ii/
	 * @interpretation
	 */
	public List<TreeNode> generateTrees2(int n) {
		return n > 0 ? helper(1, n) : new ArrayList<TreeNode>();
	}

	private List<TreeNode> helper(int from, int n) {
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (int i = 0; i <= n - 1; ++i) {
			//left i, right n-1-i
			List<TreeNode> leftList = helper(from, i);
			List<TreeNode> rightList = helper(from + i + 1, n - 1 - i);
			for (TreeNode left : leftList)
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(from + i);
					root.left = left;
					root.right = right;
					trees.add(root);
				}
		}
		if (trees.size() == 0)
			trees.add(null);
		return trees;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年3月29日
	 * @author Jiupeng
	 * @description wrong answer!!!!!!
	 * @reference 
	 * @interpretation
	 */
	public List<TreeNode> generateTrees(int n) {
		List<List<TreeNode>> treeList = new ArrayList<List<TreeNode>>();
		List<TreeNode> tree0 = new ArrayList<TreeNode>();
		tree0.add(null);
		treeList.add(tree0);
		for (int i = 1; i <= n; ++i) {
			List<TreeNode> trees = new ArrayList<TreeNode>();
			for (int j = 0, b = i - 1; j <= b; ++j) {
				List<TreeNode> leftList = treeList.get(j);
				List<TreeNode> rightList = treeList.get(i - 1 - j);
				for (TreeNode left : leftList)
					for (TreeNode right : rightList) {
						TreeNode root = new TreeNode(0);
						root.left = left;
						root.right = right;
						trees.add(root);
					}
			}
			treeList.add(trees);
		}
		tree0.remove(0);
		for (TreeNode tree : treeList.get(n))
			bst(tree, 1);
		return treeList.get(n);
	}

	private int bst(TreeNode root, int val) {
		if (root == null)
			return val - 1;
		root.val = bst(root.left, val) + 1;
		return bst(root.right, root.val + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII ubii = new UniqueBinarySearchTreesII();
		List<TreeNode> trees = ubii.generateTrees2(3);
		System.out.println();
	}

}
