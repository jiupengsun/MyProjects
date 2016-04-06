package com.samy.leetcode.algorithm.medium;

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
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * 
	 * @param root
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 33 test cases, 2ms beats 60.36%
	 * @reference https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 * @interpretation
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
		if (root == null)
			return zigzag;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int flag = 0;
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node != null) {
					if (flag == 0)
						list.add(node.val);
					else
						list.add(0, node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				} else {
					zigzag.add(list);
					flag ^= 1;
					if (!queue.isEmpty())
						queue.add(null);
					break;
				}
			}
		}
		return zigzag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
