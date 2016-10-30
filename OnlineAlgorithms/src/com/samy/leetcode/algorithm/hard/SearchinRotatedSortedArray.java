package com.samy.leetcode.algorithm.hard;

public class SearchinRotatedSortedArray {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016年3月25日
	 * @author Jiupeng
	 * @description 194 test cases, 1ms beats 5.36%
	 * @reference https://leetcode.com/problems/search-in-rotated-sorted-array/
	 * @interpretation
	 */
	public int search(int[] nums, int target) {
		int l = nums.length;
		if (target >= nums[0]) {
			if (target == nums[0])
				return 0;
			for (int i = 1; i < l && nums[i] >= nums[i - 1]; ++i)
				if (nums[i] == target)
					return i;
		} else if (target <= nums[l - 1]) {
			if (target == nums[l - 1])
				return l - 1;
			for (int i = l - 2; i >= 0 && nums[i] <= nums[i + 1]; --i)
				if (nums[i] == target)
					return i;
		}
		return -1;
	}

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * 2016年3月25日
	 * @author Jiupeng
	 * @description 194 test cases, 1ms beats 5.36%, modified binary search
	 * @reference 
	 * @interpretation
	 */
	public int search2(int[] nums, int target) {
		int i = 0, j = nums.length - 1, mid;
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
				return mid;
		}
		return nums[i] == target ? i : -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
