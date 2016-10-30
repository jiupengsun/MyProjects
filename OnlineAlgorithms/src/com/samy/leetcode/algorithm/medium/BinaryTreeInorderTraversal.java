package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê2ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description 67 test cases, 2ms beats 2.67%
	 * @reference https://leetcode.com/problems/binary-tree-inorder-traversal/
	 * @interpretation
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> treeList = new ArrayList<Integer>();
		Stack<TreeNode> treeStack = new Stack<TreeNode>();
		while (root != null || !treeStack.empty()) {
			while (root != null) {
				treeStack.push(root);
				root = root.left;
			}
			root = treeStack.pop();
			treeList.add(root.val);
			root = root.right;
		}
		return treeList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
