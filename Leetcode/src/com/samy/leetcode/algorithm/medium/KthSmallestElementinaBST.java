/**
 * 
 */
package com.samy.leetcode.algorithm.medium;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementinaBST {

	/**
	 * 
	 * @param root
	 * @param k
	 * @return
	 * 2016年2月20日
	 * @author Jiupeng
	 * @description 91 test cases, 2ms beats 15.92%
	 * @reference https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 * @interpretation
	 */
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			if (k-- > 1) {
				root = root.right;
			} else
				break;
		}
		return root.val;
	}

	/**
	 * 
	 * @param root
	 * @param k
	 * @return
	 * 2016年2月20日
	 * @author Jiupeng
	 * @description 91 test cases, 1ms beats 45.85%
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
	 */
	public int kthSmallestSample(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
		}

		return root.val;
	}

	private int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
