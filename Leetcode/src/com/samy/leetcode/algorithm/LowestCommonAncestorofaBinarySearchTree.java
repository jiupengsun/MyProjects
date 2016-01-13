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
	 * 2016年1月12日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 */
	public static TreeNode lowestCommonAncestorSample(TreeNode root, TreeNode p,
			TreeNode q) {
		List<TreeNode> ns1 = new ArrayList<TreeNode>();
		List<TreeNode> ns2 = new ArrayList<TreeNode>();
		getNodeSequence(ns1, root, p);
		getNodeSequence(ns2, root, q);
		if (ns1.size() == 0 || ns2.size() == 0)
			return null;
		// the list is in reverse order
		int i, j;
		for (i = ns1.size() - 1, j = ns2.size() - 1; i >= 0 && j >= 0; --i, --j) {
			if (ns1.get(i) != ns2.get(j))
				return (ns1.get(i + 1));
		}
		return ns1.get(i + 1);
	}

	/**
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description try to find a node that p is in its left child and q is in its right child, or vice verse.
	 * @reference
	 */
	public static TreeNode lowestCommonAncestorSample2(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null)
			return null;
		if (p == root || q == root)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}

	/**
	 * 
	 * @param list
	 * @param root
	 * @param child
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description get the sequence of node 'child' in the tree, whose root is the node 'root'
	 * the sequence is in a reverse order, and return null if the root is null, or did not find the node 'child'
	 * @reference
	 */
	private static void getNodeSequence(List<TreeNode> list, TreeNode root,
			TreeNode child) {
		if (root == null || child == null)
			return;
		if (root == child) {
			list.add(root);
			return;
		}
		getNodeSequence(list, root.left, child);
		if (list.size() == 0)
			getNodeSequence(list, root.right, child);
		if (list.size() != 0)
			list.add(root);
	}

	/**
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * 2016年1月13日
	 * @author Jiupeng
	 * @description Suppose the values in the left sub-tree of root are less than the root val, and the values 
	 * in the right sub-tree of root are greater
	 * @reference
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		int min = p.val, max = q.val;
		if (min > max) {
			min = q.val;
			max = p.val;
		}
		while (true) {
			if (root.val < min)
				root = root.right;
			else if (root.val > max)
				root = root.left;
			else
				return root;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.constructABinaryTreeSample();
		TreeNode p = root.left;
		TreeNode q = root.left.right.right;
		TreeNode lca = lowestCommonAncestor(root, p, p);
		System.out.println(lca.val);
		TreeNode lca1 = lowestCommonAncestorSample(root, p, p);
		System.out.println(lca1.val);
	}

}
