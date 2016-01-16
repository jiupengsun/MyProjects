package com.samy.leetcode.algorithm;

public class RemoveDuplicatesfromSortedArray {
	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê1ÔÂ16ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 */
	public static int removeDuplicates(int[] nums) {
		int i = 0, j = 1, l = nums.length;
		for (; j < l; ++j) {
			if (nums[j] == nums[i])
				continue;
			nums[++i] = nums[j];
		}
		return i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 1, 1, 2, 3, 3, 4 };
		int new_length = removeDuplicates(n);
		for (int i = 0; i < new_length; ++i)
			System.out.print(n[i]);
	}

}
