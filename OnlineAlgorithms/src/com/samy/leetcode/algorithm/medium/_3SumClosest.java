package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class _3SumClosest {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return Apr 6, 2016
	 * @author Jiupeng
	 * @description 120 test cases, 15ms beats 35.55%
	 * @reference https://leetcode.com/problems/3sum-closest/
	 * @interpretation
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int l = nums.length, min = Integer.MAX_VALUE;
		for (int i = 0; i < l - 2; ++i) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int j = i + 1, k = l - 1;
			while (j < k) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					++j;
					continue;
				}
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target)
					return target;
				else {
					if (abs(sum - target) < abs(min - target))
						min = sum;
					if (sum > target)
						--k;
					else
						++j;
				}
			}
		}

		return min;
	}

	private int abs(int m) {
		if (m == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		return m > 0 ? m : -m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -3, -2, -5, 3, -4 };
		int target = -1;
		_3SumClosest sum = new _3SumClosest();
		sum.threeSumClosest(nums, target);
		System.out.println(-Integer.MIN_VALUE);
	}

}
