package com.samy.leetcode.algorithm;

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
public class BinaryTreePaths {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê1ÔÂ20ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/binary-tree-paths/
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root != null) {
			StringBuilder sb = new StringBuilder();
			getAllPaths(root, paths, sb);
		}
		return paths;
	}

	private void getAllPaths(TreeNode root, List<String> paths, StringBuilder sb) {
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			paths.add(sb.toString());
			return;
		}
		sb.append("->");
		if (root.left != null)
			getAllPaths(root.left, paths, new StringBuilder(sb));
		if (root.right != null)
			getAllPaths(root.right, paths, new StringBuilder(sb));
	}

	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> list = new ArrayList<String>();
		getAllPaths2(root, list, new Stack<TreeNode>());
		return list;
	}

	public void getAllPaths2(TreeNode root, List<String> paths, Stack<TreeNode> stack) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			int i, l;
			for (i = 0, l = stack.size(); i < l; ++i) {
				sb.append(stack.get(i).val).append("->");
			}
			sb.append(root.val);
			paths.add(sb.toString());
			return;
		}
		stack.push(root);
		getAllPaths2(root.left, paths, stack);
		getAllPaths2(root.right, paths, stack);
		stack.pop();
	}

	public List<String> binaryTreePaths3(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root != null) {
			List<String> list1 = binaryTreePaths3(root.left);
			for (int i = 0, l = list1.size(); i < l; ++i) {
				list.add(String.valueOf(root.val) + "->" + list1.get(i));
			}
			list1 = binaryTreePaths3(root.right);
			for (int i = 0, l = list1.size(); i < l; ++i) {
				list.add(String.valueOf(root.val) + "->" + list1.get(i));
			}
			if (list.size() == 0)
				list.add(String.valueOf(root.val) + "");
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePaths bt = new BinaryTreePaths();
		int[] trees = { 1, 2, 3, -1, 5 };
		TreeNode t = TreeNode.constructABinaryTreeSampleByArray(trees);
		List<String> paths = bt.binaryTreePaths3(t);
		for (String s : paths)
			System.out.print(s + ",");
	}

}
