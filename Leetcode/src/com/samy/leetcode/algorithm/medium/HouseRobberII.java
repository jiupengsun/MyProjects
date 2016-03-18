package com.samy.leetcode.algorithm.medium;

public class HouseRobberII {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description 74 test cases, 1ms beats 3.61%
	 * @reference https://leetcode.com/problems/house-robber-ii/
	 * @interpretation
	 */
	public int rob(int[] nums) {
		int l = nums.length;
		switch (l) {
		case 0:
			return 0;
		case 1:
			return nums[0];
		case 2:
			return Math.max(nums[0], nums[1]);
		case 3:
			return Math.max(Math.max(nums[0], nums[1]), nums[2]);
		default:
			int[] rob0 = new int[l - 1];
			rob0[0] = nums[0];
			rob0[1] = Math.max(nums[0], nums[1]);
			int[] rob1 = new int[l - 1];
			rob1[0] = nums[1];
			rob1[1] = Math.max(nums[1], nums[2]);
			for (int i = 2; i < l - 1; ++i) {
				rob0[i] = Math.max(rob0[i - 1], rob0[i - 2] + nums[i]);
				rob1[i] = Math.max(rob1[i - 1], rob1[i - 2] + nums[i + 1]);
			}
			return Math.max(rob0[l - 2], rob1[l - 2]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5 };
		HouseRobberII hr = new HouseRobberII();
		System.out.println(hr.rob(nums));
	}

}
