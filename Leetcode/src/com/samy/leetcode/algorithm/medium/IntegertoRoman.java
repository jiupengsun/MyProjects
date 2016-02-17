package com.samy.leetcode.algorithm.medium;

public class IntegertoRoman {

	private final String[][] RomanNumber = { { "M", "MM", "MMM" },
			{ "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" } };

	/**
	 * 
	 * @param num
	 * @return
	 * 2016Äê2ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description 3999 test cases, 10ms beats 35.77%
	 * @reference https://leetcode.com/problems/integer-to-roman/
	 * @interpretation
	 */
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, base = 1000; i < 4; ++i, base /= 10) {
			if (num >= base) {
				sb.append(RomanNumber[i][num / base - 1]);
				num %= base;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
