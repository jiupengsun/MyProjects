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
		int i = 0, l = input.length(), n1 = 0;
		char c = '\0';
		while (i < l) {
			//find the first sign
			c = input.charAt(i);
			if (c < '0' || c > '9')
				break;
			++i;
		}
		n1 = Integer.parseInt(input.substring(0, i));
		calculate(c, n1, diffWaysToCompute(input.substring(i + 1)), list);
		int j = i + 1, n2 = 0;
		char c2 = '\0';
		while (j < l) {
			//find the second sign
			c2 = input.charAt(j);
			if (c2 < '0' || c2 > '9')
				break;
			++j;
		}
		if (j > i + 1) {
			switch (c) {
			case '+':
				n2 = n1 + Integer.parseInt(input.substring(i + 1, j));
				break;
			case '-':
				n2 = n1 - Integer.parseInt(input.substring(i + 1, j));
				break;
			case '*':
				n2 = n1 * Integer.parseInt(input.substring(i + 1, j));
				break;
			default:
				return list;
			}
			calculate(c2, n2, diffWaysToCompute(input.substring(i + 1)), list);
		}
		return list;
	}

	private void calculate(char sign, int left, List<Integer> right,
			List<Integer> list) {
		if (right.size() == 0) {
			list.add(left);
			return;
		}
		switch (sign) {
		case '+':
			for (int i : right)
				list.add(left + i);
			break;
		case '-':
			for (int i : right)
				list.add(left - i);
			break;
		case '*':
			for (int i : right)
				list.add(left * i);
			break;
		default:
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
