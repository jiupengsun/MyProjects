package com.samy.leetcode.algorithm.medium;

public class SearchinRotatedSortedArrayII {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016Äê3ÔÂ25ÈÕ
	 * @author Jiupeng
	 * @description 127 test cases, 1ms beats 21.8%
	 * @reference https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
	 * @interpretation
	 */
	public boolean search(int[] nums, int target) {
		int i = 0, j = nums.length - 1, mid;
		while (j > i && nums[j] == nums[i])
			--j;
		while (i < j) {
			mid = (i + j) >> 1;
			if (target < nums[mid]) {
				if (nums[mid] < nums[0] || target >= nums[i])
					j = mid - 1;
				else
					i = mid + 1;
			} else if (target > nums[mid]) {
				if (nums[mid] >= nums[0] || target <= nums[j])
					i = mid + 1;
				else
					j = mid - 1;
			} else
				return true;
		}
		return nums[i] == target;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
