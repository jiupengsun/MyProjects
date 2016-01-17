package com.samy.leetcode.algorithm;

public class PalindromeNumber {

	/**
	 * 
	 * @param x
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/palindrome-number/
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int p = x, d = 0;
		while (x > 0) {
			d = d * 10 + x % 10;
			x /= 10;
		}
		return d == p;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
