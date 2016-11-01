package com.samy.leetcode.algorithm.medium;

import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {

	/**
	 * 
	 * @param preorder
	 * @return
	 * @author Jiupeng
	 * @description 150 test cases, 15ms beats 36.72%
	 * @reference https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
	 * @interpretation
	 */
	public boolean isValidSerialization(String preorder) {
		Stack<String> stack = new Stack<String>();
		stack.push("#");
		String[] node = preorder.split(",");
		String last = null;
		for (String s : node) {
			if (s.equals("#")) {
				if (stack.isEmpty())
					return false;
				last = stack.pop();
			} else {
				stack.push(s);
			}
		}
		return stack.isEmpty() && last.equals("#");
	}

	/**
	 * 
	 * @param preorder
	 * @return
	 * @author Jiupeng
	 * @description 150 test cases, 6ms beats 97.70%. Using array instead of stack, and remove the split method
	 * @reference 
	 * @interpretation
	 */
	public boolean isValidSerialization2(String preorder) {
		int l = preorder.length(), i = -1;
		String[] stack = new String[((l + 1) >> 1) + 1];
		stack[++i] = "#";
		String last = null;
		for (int j = 0, k; j < l; j = k + 1) {
			k = j;
			while (k < l && preorder.charAt(k) != ',')
				++k;
			String s = preorder.substring(j, k);
			if (s.equals("#")) {
				if (i == -1)
					return false;
				last = stack[i--];
			} else {
				stack[++i] = s;
			}
		}
		return i == -1 && last.equals("#");
	}

	/**
	 * 
	 * @param preorder
	 * @return
	 * @author Jiupeng
	 * @description 150 test cases, 6ms beats 97.7%
	 * Counting the in-degree and out-degree, in the normal cases, the total degree of a binary tree
	 * should be zero. (the root node has two out-degree, and the leaf node only has one in-degree, the non-leaf-and-non-root node has
	 * one in-degree and two out-degree)
	 * @reference https://leetcode.com/discuss/92919/java-counting-indegree-and-outdegree-simple-%26-clear
	 * @interpretation
	 */
	public boolean isValidSerializationSample(String preorder) {
		int degree = -1;
		for (int i = 0, j, l = preorder.length(); i < l; i = j + 1) {
			j = i;
			while (j < l && preorder.charAt(j) != ',')
				++j;
			String s = preorder.substring(i, j);
			++degree;
			if (degree > 0)
				return false;
			if (!s.equals("#"))
				degree -= 2;
		}
		return degree == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
