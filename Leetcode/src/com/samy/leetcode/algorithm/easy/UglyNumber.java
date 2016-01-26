package com.samy.leetcode.algorithm.easy;

public class UglyNumber {

	/**
	 * 
	 * @param num
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/ugly-number/
	 */
	public static boolean isUgly(int num) {
		if (num < 1)
			return false;
		// cyclic divison of 2,3,5
		while ((num & 0x1) == 0)
			num >>>= 1;
		while (num == num / 3 * 3)
			num /= 3;
		while (num == num / 5 * 5)
			num /= 5;
		return num == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(Integer.MAX_VALUE));
	}

}
