package com.samy.leetcode.algorithm;

public class PowerofTwo {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/power-of-two/
	 */
	public static boolean isPowerOfTwo(int n) {
		return n < 1 ? false : (n & (n - 1)) == 0 ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
