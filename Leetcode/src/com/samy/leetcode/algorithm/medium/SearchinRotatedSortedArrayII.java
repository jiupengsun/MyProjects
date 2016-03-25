package com.samy.leetcode.algorithm.medium;

public class SearchinRotatedSortedArrayII {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016Äê3ÔÂ25ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
	 * @interpretation
	 */
	public boolean search(int[] nums, int target) {
		int l = nums.length;
		if (target >= nums[0]) {
			if (target == nums[0])
				return false;
			for (int i = 1; i < l && nums[i] >= nums[i - 1]; ++i)
				if (nums[i] == target)
					return true;
		} else if (target <= nums[l - 1]) {
			if (target == nums[l - 1])
				return true;
			for (int i = l - 2; i >= 0 && nums[i] <= nums[i + 1]; --i)
				if (nums[i] == target)
					return true;
		}
		return true;
	}

	public boolean search2(int[] nums, int target) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
