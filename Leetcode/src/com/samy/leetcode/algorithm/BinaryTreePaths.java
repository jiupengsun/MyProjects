package com.samy.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;
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
public class BinaryTreePaths {

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月20日
	 * @author Jiupeng
	 * @description use StringBuilder recursive
	 * @reference https://leetcode.com/problems/binary-tree-paths/
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		if (root != null) {
			StringBuilder sb = new StringBuilder();
			getAllPaths(root, paths, sb);
		}
		return paths;
	}

	private void getAllPaths(TreeNode root, List<String> paths,
			StringBuilder sb) {
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			paths.add(sb.toString());
			return;
		}
		sb.append("->");
		if (root.left != null)
			getAllPaths(root.left, paths, new StringBuilder(sb));
		if (root.right != null)
			getAllPaths(root.right, paths, new StringBuilder(sb));
	}

	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> list = new ArrayList<String>();
		getAllPaths2(root, list, new Stack<TreeNode>());
		return list;
	}

	/**
	 * 
	 * @param root
	 * @param paths
	 * @param stack
	 * 2016年1月21日
	 * @author Jiupeng
	 * @description use recursive, stack
	 * @reference
	 */
	public void getAllPaths2(TreeNode root, List<String> paths,
			Stack<TreeNode> stack) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			int i, l;
			for (i = 0, l = stack.size(); i < l; ++i) {
				sb.append(stack.get(i).val).append("->");
			}
			sb.append(root.val);
			paths.add(sb.toString());
			return;
		}
		stack.push(root);
		getAllPaths2(root.left, paths, stack);
		getAllPaths2(root.right, paths, stack);
		stack.pop();
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月21日
	 * @author Jiupeng
	 * @description use recursive, no stack
	 * @reference
	 */
	public List<String> binaryTreePaths3(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root != null) {
			List<String> list1 = binaryTreePaths3(root.left);
			for (int i = 0, l = list1.size(); i < l; ++i) {
				list.add(String.valueOf(root.val) + "->" + list1.get(i));
			}
			list1 = binaryTreePaths3(root.right);
			for (int i = 0, l = list1.size(); i < l; ++i) {
				list.add(String.valueOf(root.val) + "->" + list1.get(i));
			}
			if (list.size() == 0)
				list.add(String.valueOf(root.val) + "");
		}
		return list;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月21日
	 * @author Jiupeng
	 * @description use iteration, stack
	 * @reference
	 */
	public List<String> binaryTreePaths4(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		Stack<TreeNode> node = new Stack<TreeNode>();
		Stack<Character> mark = new Stack<Character>();
		char status = 'N';
		while (root != null) {
			switch (status) {
			case 'N': {
				if (root.left != null) {
					node.push(root);
					mark.push('L');
					root = root.left;
					status = 'N';
					continue;
				}
				if (root.right != null) {
					node.push(root);
					mark.push('R');
					root = root.right;
					status = 'N';
					continue;
				}
				//no children, or means it's leaf
				StringBuilder sb = new StringBuilder();
				for (int i = 0, l = node.size(); i < l; ++i) {
					sb.append(node.get(i).val + "->");
				}
				sb.append(root.val);
				paths.add(sb.toString());
				root = node.empty() ? null : node.pop();
				status = mark.empty() ? 'N' : mark.pop();
				continue;
			}
			case 'L': {
				if (root.right != null) {
					node.push(root);
					mark.push('R');
					root = root.right;
					status = 'N';
					continue;
				}
			}
			case 'R': {
				root = node.empty() ? null : node.pop();
				status = mark.empty() ? 'N' : mark.pop();
			}
			}
		}

		return paths;
	}

	/**
	 * 
	 * @param root
	 * @return
	 * 2016年1月21日
	 * @author Jiupeng
	 * @description faster
	 * @reference https://leetcode.com/discuss/79797/2ms-java-recursive-solution-with-explaination
	 */
	public List<String> binaryTreePathsSample(TreeNode root) {
		List<String> result = new ArrayList<String>();
		helper(root, result, "");
		return result;
	}

	public void helper(TreeNode root, List<String> result, String path) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(path + root.val);
			return;
		}

		helper(root.left, result, path + root.val + "->");
		helper(root.right, result, path + root.val + "->");
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreePaths bt = new BinaryTreePaths();
		int[] trees = { 1, 2, 3, -1, 5 };
		TreeNode t = TreeNode.constructABinaryTreeSampleByArray(trees);
		List<String> paths = bt.binaryTreePaths4(t);
		for (String s : paths)
			System.out.print(s + ",");
	}

}
