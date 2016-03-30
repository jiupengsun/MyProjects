package com.samy.leetcode.algorithm.medium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * 
	 * @param inorder
	 * @param postorder
	 * @return
	 * 2016Äê3ÔÂ30ÈÕ
	 * @author Jiupeng
	 * @description 202 test cases, 20ms beats 28.99%
	 * @reference https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	 * @interpretation
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode helper(int[] in, int ii, int ij, int[] po, int pi, int pj) {
		if (ii > ij || pi > pj || (ij - ii) != (pj - pi))
			return null;
		TreeNode root = new TreeNode(po[pj]);
		for (int i = ii; i <= ij; ++i) {
			if (in[i] == po[pj]) {
				//divide
				root.left = helper(in, ii, i - 1, po, pi, pi + i - 1 - ii);
				root.right = helper(in, i + 1, ij, po, pi + i - ii, pj - 1);
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
