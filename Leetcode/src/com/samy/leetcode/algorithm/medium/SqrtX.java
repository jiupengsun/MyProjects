package com.samy.leetcode.algorithm.medium;

public class SqrtX {

	private final int maxSqrt = 46340;
	private final int max = 2147395600;

	/**
	 * 
	 * @param x
	 * @return
	 * 2016Äê4ÔÂ13ÈÕ
	 * @author Jiupeng
	 * @description 1017 test cases, 3ms beats 17.23%
	 * @reference https://leetcode.com/problems/sqrtx/
	 * @interpretation
	 */
	public int mySqrt(int x) {
		if (x <= 0)
			return x;
		if (x >= max)
			return maxSqrt;
		int i = 1, j = maxSqrt - 1, mid;
		while (i <= j) {
			mid = (i + j) >> 1;
			int mul = mid * mid;
			if (x > mul)
				i = mid + 1;
			else if (x < mul)
				j = mid - 1;
			else
				return mid;
		}
		return i - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 123, 2423, 41, 5532, 6564, 131231, 53242, 654633, 23423 };
		SqrtX sx = new SqrtX();
		for (int i = 0, l = nums.length; i < l; ++i) {
			System.out.println(sx.mySqrt(nums[i]) + " " + (int) Math.sqrt(nums[i]));
		}
	}

}
