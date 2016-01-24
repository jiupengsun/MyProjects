package com.samy.leetcode.algorithm;

public class ValidPalindrome {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016Äê1ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 476 test cases, 4ms beats 98.83%
	 * @reference https://leetcode.com/problems/valid-palindrome/
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		char ci = ' ', cj = ' ';
		while (i < j) {

			while (!(((ci = s.charAt(i)) >= '0' && ci <= '9') || (ci >= 'a' && ci <= 'z') || ((ci += 32) >= 'a' && ci <= 'z'))
					&& (i < j))
				++i;
			while (!(((cj = s.charAt(j)) >= '0' && cj <= '9') || (cj >= 'a' && cj <= 'z') || ((cj += 32) >= 'a' && cj <= 'z'))
					&& (j > i))
				--j;
			if (ci != cj)
				return false;
			++i;
			--j;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Aa";
		ValidPalindrome v = new ValidPalindrome();
		v.isPalindrome(s);
	}

}
