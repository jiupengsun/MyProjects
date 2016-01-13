package com.samy.leetcode.algorithm;

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
	 * 2016Äê1ÔÂ13ÈÕ
	 * @author Jiupeng
	 * @description construct a binary tree sample
	 * 									6
	 * 					2								8
	 * 			0				4				7				9
	 * 						3		5
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
		return root;
	}
}