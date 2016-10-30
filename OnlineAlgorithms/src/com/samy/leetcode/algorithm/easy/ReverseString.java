package com.samy.leetcode.algorithm.easy;

public class ReverseString {

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 22, 2016
	 * @author Jiupeng
	 * @description 476 test cases, 5ms
	 * @reference https://leetcode.com/problems/reverse-string/
	 * @interpretation
	 */
	public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int l = s.length(), i = l - 1; i >= 0; --i)
			sb.append(s.charAt(i));
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
