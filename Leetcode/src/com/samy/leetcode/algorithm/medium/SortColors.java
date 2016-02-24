package com.samy.leetcode.algorithm.medium;

public class SortColors {

	/**
	 * 
	 * @param nums
	 * 2016Äê2ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 86 test cases, 0ms beats 79.34%
	 * using three variables, moving 0 to the left, and moving 2 to the right
	 * @reference https://leetcode.com/problems/sort-colors/
	 * @interpretation
	 */
	public void sortColors(int[] nums) {
		int left = 0, i = left, j = nums.length - 1;
		while (i <= j) {
			if (nums[i] == 0) {
				nums[i] = nums[left];
				nums[left++] = 0;
			} else if (nums[i] == 2) {
				nums[i--] = nums[j];
				nums[j--] = 2;
			}
			++i;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
