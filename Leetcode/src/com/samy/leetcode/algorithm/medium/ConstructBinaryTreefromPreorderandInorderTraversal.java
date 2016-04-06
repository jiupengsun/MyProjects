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
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 * Apr 6, 2016
	 * @author Jiupeng
	 * @description 202 test cases, 20ms beats 31.46%
	 * @reference https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	 * @interpretation
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int pst, int pen, int[] inorder, int ist, int ien) {
		if (pst > pen || ist > ien)
			return null;
		TreeNode root = new TreeNode(preorder[pst]);
		for (int i = ist; i <= ien; ++i) {
			if (inorder[i] == preorder[pst]) {
				root.left = helper(preorder, pst + 1, pst + i - ist, inorder, ist, i - 1);
				root.right = helper(preorder, pst + i - ist + 1, pen, inorder, i + 1, ien);
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[] { 1, 2, 4, 5, 3, 6, 7 };
		int[] inorder = new int[] { 4, 2, 5, 1, 6, 3, 7 };
		ConstructBinaryTreefromPreorderandInorderTraversal cb = new ConstructBinaryTreefromPreorderandInorderTraversal();
		cb.buildTree(preorder, inorder);
	}

}
