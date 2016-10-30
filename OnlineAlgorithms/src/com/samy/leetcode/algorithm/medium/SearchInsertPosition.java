package com.samy.leetcode.algorithm.medium;

public class SearchInsertPosition {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016Äê2ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description 62 test cases, 0ms beats 17.59%
	 * @reference https://leetcode.com/problems/search-insert-position/
	 * @interpretation
	 */
	public int searchInsert(int[] nums, int target) {
		int l = nums.length;
		int i = 0, j = l - 1, mid = (i + j) >> 1;
		while (i <= j) {
			if (target > nums[mid])
				i = mid + 1;
			else if (target < nums[mid])
				j = mid - 1;
			else
				return mid;
			mid = (i + j) >> 1;
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
