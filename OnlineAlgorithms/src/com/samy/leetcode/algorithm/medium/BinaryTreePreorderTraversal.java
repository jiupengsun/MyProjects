package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	/**
	 * @param root
	 * @return
	 * 2016年2月16日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/binary-tree-preorder-traversal/
	 * @interpretation
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> treeList = new ArrayList<Integer>();
		Stack<TreeNode> treeStack = new Stack<TreeNode>();
		if (root != null)
			treeStack.push(root);
		while (!treeStack.empty()) {
			TreeNode node = treeStack.pop();
			treeList.add(node.val);
			if (node.right != null)
				treeStack.push(node.right);
			if (node.left != null)
				treeStack.push(node.left);
		}
		return treeList;
	}

	/**
	 * @param root
	 * @return
	 * 2016年2月16日
	 * @author Jiupeng
	 * @description 67 test cases, 1ms beats 54.23%
	 * @reference https://leetcode.com/problems/binary-tree-preorder-traversal/
	 * @interpretation
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> treeList = new ArrayList<Integer>();
		Stack<TreeNode> treeStack = new Stack<TreeNode>();
		while (root != null || !treeStack.empty()) {
			while (root != null) {
				treeList.add(root.val);
				treeStack.add(root);
				root = root.left;
			}
			root = treeStack.pop();
			root = root.right;
		}
		return treeList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	/**
	 * 
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description construct a binary tree sample
	 * 									6
	 * 					2								8
	 * 			0				4				7				9
	 * 						3		5								10
	 * 																		11
	 * @reference
	 */
	static TreeNode constructABinaryTreeSample() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(10);
		root.right.right.right.right = new TreeNode(11);
		return root;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description construct a binary tree according to the array
	 * the element of array should meet the position of a complete binary tree, and equal -1 if the node is null
	 * @reference
	 */
	static TreeNode constructABinaryTreeSampleByArray(int[] n) {
		return constructSubTree(0, 0, n);
	}

	private static TreeNode constructSubTree(int h, int i, int[] n) {
		if (i >= n.length || n[i] < 0)
			return null;
		TreeNode tn = new TreeNode(n[i]);
		tn.left = constructSubTree(h + 1, 2 * i + 1, n);
		tn.right = constructSubTree(h + 1, 2 * i + 2, n);
		return tn;
	}

	/**
	 * 
	 * @param root
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description print a binary tree with inorder traversal
	 * @reference
	 */
	static void printBinaryTreeInorderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		printBinaryTreeInorderTraversal(root.left);
		printBinaryTreeInorderTraversal(root.right);
	}
}