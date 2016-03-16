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
		Stack<Character> signs = new Stack<Character>();
		Stack<Integer> numbers = new Stack<Integer>();
		int l = input.length(), i = l, j = l - 1;
		while (j >= 0) {
			char c = input.charAt(j);
			if (c >= '0' && c <= '9')
				--j;
			else {
				numbers.push(Integer.parseInt(input.substring(j + 1, i)));
				signs.push(c);
				i = j--;
			}
		}
		if (j < 0)
			numbers.push(Integer.parseInt(input.substring(0, i)));

		return calculate(signs, numbers);
	}

	private List<Integer> calculate(Stack<Character> signs, Stack<Integer> numbers) {
		List<Integer> list = new ArrayList<Integer>();
		if (numbers.size() == 1)
			list.add(numbers.peek());
		else if (numbers.size() > 1) {
			int n1 = numbers.pop();
			char c1 = signs.pop();
			int n2 = numbers.pop();
			int n = helper(n1, n2, c1);
			helper(n1, c1, calculate(signs, numbers), list);
			if (signs.size() > 0) {
				char c2 = signs.pop();
				helper(n, c2, calculate(signs, numbers), list);
				signs.push(c2);
			} else
				list.add(n);
			numbers.push(n2);
			numbers.push(n1);
			signs.push(c1);
		}
		return list;
	}

	private void helper(int n, char c, List<Integer> subList, List<Integer> list) {
		switch (c) {
		case '+':
			for (int i : subList)
				list.add(n + i);
			break;
		case '-':
			for (int i : subList)
				list.add(n - i);
			break;
		case '*':
			for (int i : subList)
				list.add(n * i);
			break;
		default:
			return;
		}

	}

	private int helper(int n1, int n2, char c) {
		switch (c) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "2-1-1";
		DifferentWaystoAddParentheses dw = new DifferentWaystoAddParentheses();
		System.out.println(dw.diffWaysToCompute(input));

	}

}
