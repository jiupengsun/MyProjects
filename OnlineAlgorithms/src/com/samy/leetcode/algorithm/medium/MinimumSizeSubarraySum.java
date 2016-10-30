package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

	/**
	 * 
	 * @param s
	 * @param nums
	 * @return
	 * Apr 10, 2016
	 * @author Jiupeng
	 * @description 14 test cases, 1ms beats 18.63%
	 * Notice that this question requires to count the subarray, not the minimus numbers 
	 * that the sum of which is larger or equal than s. Totally different
	 * @reference https://leetcode.com/problems/minimum-size-subarray-sum/
	 * @interpretation
	 */
	public int minSubArrayLen(int s, int[] nums) {
		int l = nums.length;
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
		for (j = 0; j < l; ++j) {
			if (nums[j] >= s)
				return 1;
			sum += nums[j];
			while (sum >= s) {
				min = Math.min(min, j - i + 1);
				sum -= nums[i++];
			}
		}
		return j - i == l ? 0 : min;
	}

	/**
	 * 
	 * @param s
	 * @param nums
	 * @return
	 * Apr 10, 2016
	 * @author Jiupeng
	 * @description TLE, O(nlogn) time complexity
	 * @reference 
	 * @interpretation
	 */
	public int minSubArrayLenSlow(int s, int[] nums) {
		Arrays.sort(nums);
		int l = nums.length;
		for (int i = l - 1, sum = 0; i >= 0; --i) {
			sum += nums[i];
			if (sum >= s)
				return l - i;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
