package com.samy.leetcode.algorithm.medium;

public class JumpGame {

	/**
	 * 
	 * @param nums
	 * @return
	 * Apr 7, 2016
	 * @author Jiupeng
	 * @description 72 test cases, 3ms beats 27.06%
	 * @reference https://leetcode.com/problems/jump-game/
	 * @interpretation
	 */
	public boolean canJump(int[] nums) {
		int l = nums.length, max = 0;
		for (int i = 0; i <= max && max < l - 1; ++i) {
			max = Math.max(nums[i] + i, max);
		}
		return max >= l - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
