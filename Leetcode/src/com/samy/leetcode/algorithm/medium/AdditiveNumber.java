package com.samy.leetcode.algorithm.medium;

public class AdditiveNumber {

	/**
	 * 
	 * @param num
	 * @return
	 * Apr 11, 2016
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/additive-number/
	 * @interpretation
	 */
	public boolean isAdditiveNumber(String num) {
		int l = num.length();
		long n1, n2, n3;
		for (int i = 0, t = l >> 1; i < t; ++i) {
			for (int j = i + 1; j <= t; ++j) {
				n1 = Long.parseLong(num.substring(0, i + 1));
				n2 = Long.parseLong(num.substring(i + 1, j + 1));
				n3 = n1 + n2;
				String s = String.valueOf(n3);
				int p = 0, q = s.length();
				while (p < q && j + 1 + p < l && num.charAt(j + 1 + p) == s.charAt(p))
					++p;
				if (p == q) {

				} else {
					// not equal
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
