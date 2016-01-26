package com.samy.leetcode.algorithm.easy;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/valid-parentheses/
	 */

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		//no need to check if the stack is empty
		stack.push('t');
		char c;
		int d = 0;
		for (int i = 0, l = s.length(); i < l; ++i) {
			c = s.charAt(i);
			d = 0;
			if (((d = c - stack.peek().charValue()) == 1 || d == 2)) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.size() == 1;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/discuss/65473/short-easy-to-follow-8ms-java-solution
	 */
	public boolean isValidSample(String s) {
		int length;

		do {
			length = s.length();
			s = s.replace("()", "").replace("{}", "").replace("[]", "");
		} while (length != s.length());

		return s.length() == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
