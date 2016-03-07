package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年3月6日
	 * @author Jiupeng
	 * @description 210 test cases, 3ms beats 10.90%
	 * @reference https://leetcode.com/problems/binary-tree-right-side-view/
	 * @interpretation
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			list.add(root.val);
			List<Integer> listLeft = rightSideView(root.left);
			List<Integer> listRight = rightSideView(root.right);
			list.addAll(listRight);
			int ll, lr;
			if ((ll = listLeft.size()) > (lr = listRight.size())) {
				for (int i = lr; i < ll; ++i)
					list.add(listLeft.get(i));
			}
		}
		return list;
	}

	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int last = 0;
		if (root != null) {
			queue.add(root);
			queue.add(null);
		}
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.remove();
			if (tmp != null) {
				last = tmp.val;
				if (tmp.left != null)
					queue.add(tmp.left);
				if (tmp.right != null)
					queue.add(tmp.right);
			} else {
				//move to the next round
				list.add(last);
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return list;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年3月7日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/discuss/85020/java-easy-solution-beats-90%25-using-dfs
	 * @interpretation
	 */
	public List<Integer> rightSideViewSample(TreeNode root) {
		List<Integer> view = new ArrayList<Integer>();
		if (null == root)
			return view;
		dfs(view, root, 1);
		return view;
	}

	private void dfs(List<Integer> view, TreeNode root, int layer) {
		if (root == null)
			return;
		if (layer > view.size())
			view.add(root.val);
		dfs(view, root.right, layer + 1);
		dfs(view, root.left, layer + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
