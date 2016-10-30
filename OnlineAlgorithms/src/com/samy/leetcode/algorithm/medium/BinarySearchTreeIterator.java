package com.samy.leetcode.algorithm.medium;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class BinarySearchTreeIterator {

	private Stack<TreeNode> stack;
	private TreeNode current;

	/**
	 * 
	 * @param root
	 * 2016Äê3ÔÂ3ÈÕ
	 * @author Jiupeng
	 * @description 61 test cases, 7ms beats 14.67%
	 * @reference https://leetcode.com/problems/binary-search-tree-iterator/
	 * @interpretation
	 */
	public BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (!stack.isEmpty() || (current != null && current.right != null))
			return true;
		return false;
	}

	/** @return the next smallest number */
	public int next() {
		if (current == null || current.right == null)
			current = stack.pop();
		else {
			current = current.right;
			while (current.left != null) {
				stack.push(current);
				current = current.left;
			}
		}
		return current.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
