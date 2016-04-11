package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * 
	 * @param nums
	 * Apr 10, 2016
	 * @author Jiupeng
	 * @description 265 test cases, 2ms beats 9.15%
	 * @reference https://leetcode.com/problems/next-permutation/
	 * @interpretation
	 */
	public void nextPermutation(int[] nums) {
		int i, l = nums.length;
		for (i = l - 2; i >= 0; --i) {
			if (nums[i] < nums[i + 1])
				break;
		}
		if (i > -2) {
			sort(nums, i + 1, l);
			if (i >= 0)
				for (int j = i + 1; j < l; ++j)
					if (nums[j] > nums[i]) {
						swap(nums, i, j);
						break;
					}
		}
	}

	private void sort(int[] nums, int i, int j) {
		Arrays.sort(nums, i, j);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
