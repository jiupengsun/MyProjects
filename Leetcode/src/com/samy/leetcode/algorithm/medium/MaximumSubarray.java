package com.samy.leetcode.algorithm.medium;

public class MaximumSubarray {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description 201 test cases, 1ms beats 70.55%
	 * @reference https://leetcode.com/problems/maximum-subarray/
	 * @interpretation
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0, l = nums.length; i < l; ++i) {
			sum += nums[i];
			if (nums[i] > sum)
				sum = nums[i];
			max = max > sum ? max : sum;
		}
		return max;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description
	 * @reference not practical yet
	 * @interpretation https://en.wikipedia.org/wiki/Divide_and_conquer_algorithms
	 */
	public int maxSubArrayDCSolution(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1).sum;
	}

	private triple maxSubArray(int[] nums, int st, int en) {
		triple t = new triple();
		if (st == en) {
			t.st = st;
			t.en = st;
			t.sum = nums[st];
		} else {
			int mid = (st + en) >> 1;
			triple left = maxSubArray(nums, st, mid);
			triple right = maxSubArray(nums, mid + 1, en);
			int sum = left.sum + right.sum;
			for (int i = left.en + 1, j = right.st - 1; i <= j; ++i) {
				sum += nums[i];
			}
			if (sum > left.sum && sum > right.sum) {
				t.st = left.st;
				t.en = right.en;
				t.sum = sum;
			} else {
				t = left.sum > right.sum ? left : right;
			}
		}
		return t;
	}

	private class triple {
		int st;
		int en;
		int sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
