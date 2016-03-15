package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		if (input != null && input.length() > 0) {
			//read the first number
			int i = 0, l = input.length();
			while (i < l) {
				char c = input.charAt(i);
				if (c < '0' || c > '9')
					break;
				++i;
			}
			if (i > 0) {
				int n1 = Integer.parseInt(input.substring(0, i));

				//read the second number
			}
		}

		return list;
	}

	private List<Integer> calculate(Stack<Character> signs,
			Stack<Integer> numbers) {
		List<Integer> list = new ArrayList<Integer>();

		if (numbers.size() == 1)
			list.add(numbers.pop());
		else if (numbers.size() > 1) {
			int n1 = numbers.pop();
			char c1 = signs.pop();
			List<Integer> subList = calculate(signs, numbers);
			if (subList.size() > 0) {

			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "0+1";
		DifferentWaystoAddParentheses dwa = new DifferentWaystoAddParentheses();
		dwa.diffWaysToCompute(input);
	}

}
