package com.samy.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description 2ms
	 * @reference https://leetcode.com/problems/binary-tree-level-order-traversal/
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> treelist = new ArrayList<List<Integer>>();
		if (root != null) {
			Queue<TreeNode> nodelist = new LinkedList<TreeNode>();
			nodelist.add(root);
			int count = 1, total = 0;
			List<Integer> level = new ArrayList<Integer>();
			while (!nodelist.isEmpty()) {
				while (count-- > 0) {
					TreeNode node = nodelist.poll();
					level.add(node.val);
					if (node.left != null) {
						nodelist.add(node.left);
						++total;
					}
					if (node.right != null) {
						nodelist.add(node.right);
						++total;
					}
				}
				treelist.add(level);
				level = new ArrayList<Integer>();
				count = total;
				total = 0;
			}
		}
		return treelist;
	}

	public static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> valuelist = new ArrayList<List<Integer>>();
		if (root != null) {
			List<List<TreeNode>> treelist = new ArrayList<List<TreeNode>>();
			List<TreeNode> nodelist = new ArrayList<TreeNode>();
			nodelist.add(root);
			treelist.add(nodelist);
			for (int i = 0; i < treelist.size(); ++i) {
				List<Integer> value = new ArrayList<Integer>();
				List<TreeNode> tmp = treelist.get(i);
				nodelist = new ArrayList<TreeNode>();
				for (int j = 0; j < tmp.size(); ++j) {
					TreeNode node = tmp.get(j);
					if (node != null) {
						value.add(node.val);
						nodelist.add(node.left);
						nodelist.add(node.right);
					}
				}
				if (nodelist.size() > 0) {
					treelist.add(nodelist);
					valuelist.add(value);
				}
			}
		}
		return valuelist;
	}

	public List<List<Integer>> levelOrder3(TreeNode root) {
		List<List<Integer>> treelist = new ArrayList<List<Integer>>();
		if (root != null) {
			Queue<TreeNode> nodelist = new LinkedList<TreeNode>();
			nodelist.add(root);
			nodelist.add(null);
			List<Integer> level = new ArrayList<Integer>();
			while (nodelist.size() > 0) {
				TreeNode node = nodelist.poll();
				if (node != null) {
					level.add(node.val);
					if (node.left != null)
						nodelist.add(node.left);
					if (node.right != null)
						nodelist.add(node.right);
				} else {
					treelist.add(level);
					if (nodelist.size() == 0)
						return treelist;
					nodelist.add(null);
					level = new ArrayList<Integer>();
				}
			}
		}
		return treelist;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月17日
	 * @author Jiupeng
	 * @description 1ms
	 * @reference https://leetcode.com/discuss/80170/1-ms-java-easy-recursive-solution
	 */
	public List<List<Integer>> levelOrderSample(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root != null) {
			levelOrderR(root, 0, result);
		}
		return result;
	}

	public void levelOrderR(TreeNode p, int level, List<List<Integer>> result) {
		if (p == null) {
			return;
		}
		ArrayList<Integer> current;
		if (level >= result.size()) {
			current = new ArrayList<>();
			result.add(current);
		} else {
			current = (ArrayList<Integer>) result.get(level);
		}
		current.add(p.val);
		levelOrderR(p.left, level + 1, result);
		levelOrderR(p.right, level + 1, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 3, 9, 20, -1, -1, 15, 7 };
		TreeNode head = TreeNode.constructABinaryTreeSampleByArray(n);
		List<List<Integer>> treelist = levelOrder(head);
		System.out.println(treelist);
	}

}
