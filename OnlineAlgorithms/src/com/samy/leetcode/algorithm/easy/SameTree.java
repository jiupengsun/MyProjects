package com.samy.leetcode.algorithm.easy;

public class SameTree {

	/**
	 * 
	 * @param p
	 * @param q
	 * @return 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description There is another solution, which is try to conver the tree to
	 *              a string according to its val in a specific traverse method
	 * @reference https://leetcode.com/problems/same-tree/
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
