package com.samy.leetcode.algorithm.easy;

public class MaxDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftDepth = 1, rightDepth = 1;
		leftDepth = maxDepth(root.left) + 1;
		rightDepth = maxDepth(root.right) + 1;
		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.constructABinaryTreeSample();
		System.out.println(maxDepth(root));

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