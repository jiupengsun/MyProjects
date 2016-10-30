package com.samy.leetcode.algorithm.medium;

public class MissingNumber {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月16日
	 * @author Jiupeng
	 * @description 121 test cases, 1ms beats 39.28%
	 * @reference https://leetcode.com/problems/missing-number/
	 * @interpretation
	 */
	public int missingNumber(int[] nums) {
		int l = nums.length;
		long sum = 0;
		for (int i : nums)
			sum += i;
		return (int) ((l * (l + 1) >> 1) - sum);
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月16日
	 * @author Jiupeng 
	 * @description 121 test cases, 1ms beats 39.28%. Without overflow
	 * @reference
	 * @interpretation
	 */
	public int missingNumber2(int[] nums) {
		int l = nums.length;
		int xor = 0;
		for (int i : nums)
			xor ^= i;
		switch (l - (l >> 2 << 2)) {
		case 0:
			return l ^ xor;
		case 1:
			return 1 ^ xor;
		case 2:
			return (l + 1) ^ xor;
		default:
			return xor;
		}
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月16日
	 * @author Jiupeng 
	 * @description 121 test cases, 1ms beats 39.28%. Without overflow and much cleaner
	 * @reference
	 * @interpretation
	 */
	public int missingNumber3(int[] nums) {
		int l = nums.length;
		int x = 0, y = 0;
		for (int i = 0; i < l; ++i) {
			x ^= nums[i];
			y ^= i;
		}
		y ^= l;
		return x ^ y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE % 4);
	}

}
