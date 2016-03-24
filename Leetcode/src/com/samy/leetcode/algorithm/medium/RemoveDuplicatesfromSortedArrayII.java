package com.samy.leetcode.algorithm.medium;

public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 164 test cases, 1ms beats 62.51%
	 * @reference https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	 * @interpretation
	 */
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 0, l = nums.length;
		while (j < l) {
			//move j
			while (j < l - 2 && nums[j] == nums[j + 2])
				++j;
			//
			nums[i++] = nums[j++];
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 2, 3 };
		RemoveDuplicatesfromSortedArrayII rs = new RemoveDuplicatesfromSortedArrayII();
		rs.removeDuplicates(nums);
	}

}
