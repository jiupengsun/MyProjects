package com.samy.leetcode.algorithm.medium;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * 
	 * @param root
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description 14 test cases, 1ms beats 29.13%
	 * @reference https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
	 * @interpretation
	 */
	public void connect(TreeLinkNode root) {
		if (root != null && root.left != null) {
			root.left.next = root.right;
			root.right.next = root.next == null ? null : root.next.left;
			connect(root.left);
			connect(root.right);
		}
	}

	/**
	 * 
	 * @param root
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description 14 test cases, 0ms beats 82.19%. Without recursive, using the character of 
	 * perfect binary tree, connect it with iteration
	 * @reference 
	 * @interpretation
	 */
	public void connect2(TreeLinkNode root) {
		while (root != null && root.left != null) {
			TreeLinkNode leftMost = root;
			while (root != null) {
				root.left.next = root.right;
				root.right.next = root.next == null ? null : root.next.left;
				root = root.next;
			}
			root = leftMost.left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}