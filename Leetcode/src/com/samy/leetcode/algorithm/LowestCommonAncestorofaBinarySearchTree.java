package com.samy.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinarySearchTree {

	/**
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 * 2016Äê1ÔÂ12ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		List<TreeNode> nodeSequence1 = new ArrayList<TreeNode>();
		List<TreeNode> nodeSequence2 = new ArrayList<TreeNode>();
		getNodeSequence(nodeSequence1, root, p);
		getNodeSequence(nodeSequence2, root, q);

		return null;
	}

	private static void getNodeSequence(List<TreeNode> list, TreeNode root,
			TreeNode child) {
		if (list.size() != 0) {
			list.add(root);
			return;
		}
		if (root == null || child == null)
			return;
		if (root.val == child.val) {
			list.add(root);
			return;
		}
		getNodeSequence(list, root.left, child);
		if (list.size() != 0) {
			list.add(root);
			return;
		}
		getNodeSequence(list, root.right, child);
		if (list.size() != 0)
			list.add(root);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
