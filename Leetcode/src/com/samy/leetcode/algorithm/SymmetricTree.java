package com.samy.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */

	/**
	 * 
	 * @param root
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/symmetric-tree/
	 */
	public boolean isSymmetric(TreeNode root) {
		List<Integer> nodeList = new ArrayList<Integer>();
		getSequence(nodeList, root);
		int i = 0, length = nodeList.size();
		for (; i < length - i; ++i) {
			if (nodeList.get(i) != nodeList.get(length - 1 - i))
				return false;
		}
		return true;
	}

	private void getSequence(List<Integer> nodeList, TreeNode root) {
		if (root == null)
			return;
		getSequence(nodeList, root.left);
		nodeList.add(root.val);
		getSequence(nodeList, root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymmetricTree s = new SymmetricTree();
		int[] n = { 1, 2, 3, 3, -1, 2, -1 };
		TreeNode tn = TreeNode.constructABinaryTreeSampleByArray(n);
		System.out.println(s.isSymmetric(tn));
	}

}
