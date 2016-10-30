package com.samy.leetcode.algorithm.medium;

public class FindMinimuminRotatedSortedArray {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê2ÔÂ21ÈÕ
	 * @author Jiupeng
	 * @description 146 test cases, 1ms beats 2.33%
	 * @reference https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	 * @interpretation
	 */
	public int findMin(int[] nums) {
		int min = nums[0];
		for (int i = 1, l = nums.length; i < l; ++i)
			if (min > nums[i])
				min = nums[i];
		return min;
	}

	public int findMin2(int[] nums) {
		int min = nums[0];
		int i = 1, l = nums.length;
		while (i < l && nums[i] > nums[i - 1])
			++i;
		return i == l ? min : nums[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
