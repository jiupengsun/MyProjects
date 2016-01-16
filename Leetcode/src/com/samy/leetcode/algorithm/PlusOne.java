package com.samy.leetcode.algorithm;

public class PlusOne {
	/**
	 * 
	 * @param digits
	 * @return
	 * 2016Äê1ÔÂ16ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/plus-one/
	 */
	public int[] plusOne(int[] digits) {
		int l = digits.length;
		for (int i = l - 1; i >= 0; --i) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}
		int[] new_digits = new int[l + 1];
		new_digits[0] = 1;
		return new_digits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
