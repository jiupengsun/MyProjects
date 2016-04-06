package com.samy.leetcode.algorithm.medium;

public class SearchforaRange {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return Apr 6, 2016
	 * @author Jiupeng
	 * @description 81 test cases, 0ms beats 65.47%
	 * @reference https://leetcode.com/problems/search-for-a-range/
	 * @interpretation
	 */
	public int[] searchRange(int[] nums, int target) {
		int i = 0, j = nums.length - 1, mid;
		while (i <= j) {
			mid = (i + j) >> 1;
			if (nums[mid] == target) {
				int m = mid, n = mid;
				while (m >= 0 && nums[m] == target)
					--m;
				while (n < nums.length && nums[n] == target)
					++n;
				return new int[] { m + 1, n - 1 };
			} else if (nums[mid] > target)
				j = mid - 1;
			else
				i = mid + 1;
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
