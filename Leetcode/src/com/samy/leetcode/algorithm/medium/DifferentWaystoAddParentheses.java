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
	 * @description
	 * @reference https://leetcode.com/problems/different-ways-to-add-parentheses/
	 * @interpretation
	 */
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> list = new ArrayList<Integer>();
		if (input == null || input.length() == 0)
			return list;
		int round = 2;
		for (int i = 0, l = input.length(); i < l && round > 0; --round, ++i) {
			while (i < l && input.charAt(i) >= '0' && input.charAt(i) <= '9')
				++i;
			if (round == 2 && i == l) {
				list.add(Integer.parseInt(input));
				return list;
			}
			calculate(input.charAt(i), diffWaysToCompute(input.substring(0, i)), diffWaysToCompute(input.substring(i + 1)),
					list);
		}
		return list;
	}

	private void calculate(char sign, List<Integer> left, List<Integer> right, List<Integer> list) {
		if (left.size() == 0 && right.size() == 0) {
			return;
		} else if (left.size() == 0)
			list.addAll(right);
		else if (right.size() == 0)
			list.addAll(left);
		else {
			switch (sign) {
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

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "0+1";
		DifferentWaystoAddParentheses dwa = new DifferentWaystoAddParentheses();
		dwa.diffWaysToCompute(input);
	}

}
