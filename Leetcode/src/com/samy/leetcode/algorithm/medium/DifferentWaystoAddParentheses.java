package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		Queue<Character> signs = new LinkedList<Character>();
		Queue<Integer> numbers = new LinkedList<Integer>();
		int i = 0, j = 0, l = input.length();
		while (j < l) {
			char c = input.charAt(j);
			if (c >= '0' && c <= '9')
				++j;
			else {
				numbers.add(Integer.parseInt(input.substring(i, j)));
				signs.add(c);
				i = ++j;
			}
		}
		if (j > i)
			numbers.add(Integer.parseInt(input.substring(i, j)));

		return calculate(signs, numbers);
	}

	private List<Integer> calculate(Queue<Character> signs,
			Queue<Integer> numbers) {
		List<Integer> list = new ArrayList<Integer>();
		if (numbers.size() == 1)
			list.add(numbers.peek());
		else if (numbers.size() > 1) {
			int n1 = numbers.poll();
			char c1 = signs.poll();
			helper(n1, c1, calculate(signs, numbers), list);
			int n2 = numbers.poll();
			int n = helper(n1, n2, c1);
			if (signs.size() > 0) {
				char c2 = signs.poll();
				helper(n, c2, calculate(signs, numbers), list);
				signs.add(c2);
			} else
				list.add(n);
			numbers.add(n2);
			numbers.add(n1);
			signs.add(c1);
		}
		return list;
	}

	private void helper(int n, char c, List<Integer> subList,
			List<Integer> list) {
		if (subList.size() == 0)
			list.add(n);
		else {
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
