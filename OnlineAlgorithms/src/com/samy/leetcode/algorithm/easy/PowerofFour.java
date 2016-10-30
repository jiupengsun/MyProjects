package com.samy.leetcode.algorithm.easy;

public class PowerofFour {

	private final int mask = 0xAAAAAAAA;

	/**
	 * 
	 * @param num
	 * @return
	 * Apr 18, 2016
	 * @author Jiupeng
	 * @description 1018 test cases, 2ms
	 * @reference https://leetcode.com/problems/power-of-four/
	 * @interpretation
	 */
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & mask) == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer.bitCount(1);
	}

}
