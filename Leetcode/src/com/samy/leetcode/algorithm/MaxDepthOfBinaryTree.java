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
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(6);
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
}