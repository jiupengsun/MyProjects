package com.samy.leetcode.algorithm.medium;

public class SingleNumber {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ29ÈÕ
	 * @author Jiupeng
	 * @description 15 test cases, 1ms beats 35.11%
	 * @reference https://leetcode.com/problems/single-number/
	 */
	public int singleNumber(int[] nums) {
		int s = 0;
		for (int i = 0, l = nums.length; i < l; ++i)
			s ^= nums[i];
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
