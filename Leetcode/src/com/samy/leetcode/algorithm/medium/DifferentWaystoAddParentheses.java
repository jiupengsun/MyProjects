package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {

	/**
	 * 
	 * @param input
	 * @return
	 * 2016Äê3ÔÂ7ÈÕ
	 * @author Jiupeng
	 * @description 24 test cases, 5ms beats 88.28%
	 * @reference https://leetcode.com/problems/different-ways-to-add-parentheses/
	 * @interpretation https://hzhou.me/LeetCode/LeetCode-Different-Ways-to-Add-Parentheses.html
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> list = new ArrayList<Integer>();
		int l = input.length();
		for (int i = 1; i < l - 1; ++i) {
			char c = input.charAt(i);
			if (c < '0' || c > '9') {
				//sign
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				helper(left, right, c, list);
			}
		}
		if (l > 0 && list.isEmpty())
			list.add(Integer.parseInt(input));
		return list;
	}

	private void helper(List<Integer> left, List<Integer> right, char c,
			List<Integer> list) {
		switch (c) {
		case '+':
			for (int l : left)
				for (int r : right)
					list.add(l + r);
			break;
		case '-':
			for (int l : left)
				for (int r : right)
					list.add(l - r);
			break;
		case '*':
			for (int l : left)
				for (int r : right)
					list.add(l * r);
			break;
		default:
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2*3-4*5";
		DifferentWaystoAddParentheses dw = new DifferentWaystoAddParentheses();
		System.out.println(dw.diffWaysToCompute(input));

	}

}
