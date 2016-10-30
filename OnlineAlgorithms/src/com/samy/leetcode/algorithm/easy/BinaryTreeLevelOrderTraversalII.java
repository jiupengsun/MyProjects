package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int s;
		while ((s = q.size()) > 0) {
			List<Integer> l = new ArrayList<Integer>();
			while ((s--) > 0) {
				TreeNode tn = q.poll();
				if (tn != null) {
					l.add(tn.val);
					q.add(tn.left);
					q.add(tn.right);
				}
			}
			if (l.size() > 0)
				list.add(0, l);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
