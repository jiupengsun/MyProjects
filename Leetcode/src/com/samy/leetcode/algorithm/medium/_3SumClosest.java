package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class _3SumClosest {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016Äê3ÔÂ30ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/3sum-closest/
	 * @interpretation
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int i = 0, l = nums.length, min = Integer.MAX_VALUE;
		while (i < l && nums[i] < target)
			++i;
		if (i == l) {
			return nums[l - 1] + nums[l - 2] + nums[l - 3];
		} else if (i == 0) {
			return nums[0] + nums[1] + nums[2];
		} else {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
