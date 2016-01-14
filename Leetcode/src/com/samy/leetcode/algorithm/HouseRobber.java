package com.samy.leetcode.algorithm;

public class HouseRobber {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/house-robber/
	 */
	public int rob(int[] nums) {
		int odd = 0, even = 0;
		for (int i = 0; i < nums.length; ++i) {
			if ((i & 1) == 0)
				even += nums[i];
			else
				odd += nums[i];
		}
		return Math.max(odd, even);
	}

	public int robWithOnlyTwoHouses(int[] nums) {
		switch (nums.length) {
		case 0: {
			return 0;
		}
		case 1: {
			return nums[0];
		}
		case 2: {
			return Math.max(nums[0], nums[1]);
		}
		case 3: {
			return Math.max(nums[1], nums[0] + nums[2]);
		}
		default: {
			int[] big = new int[4];
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] > big[0]) {
					int j = 1, k = 0;
					for (; j < 4; ++j)
						if (nums[i] < big[j])
							break;
					for (; k < j - 1; ++k) {
						big[k] = big[k + 1];
					}
					big[k] = i;
				}
			}
			return max(nums, big[0], big[1], big[2], big[3]);
		}
		}
	}

	/**
	 * 
	 * @param nums
	 * @param b0
	 * @param b1
	 * @param b2
	 * @param b3
	 * @return
	 * 2016年1月15日
	 * @author Jiupeng
	 * @description from small to big: b0 ~ b3
	 * @reference
	 */
	private int max(int[] nums, int b0, int b1, int b2, int b3) {
		if (Math.abs(b3 - b2) == 1) {
			if (Math.abs(b3 - b1) == 1) {
				if (Math.abs(b2 - b1) == 1)
					return nums[b3] + nums[b0];
				else
					return Math.max(nums[b3] + nums[b0], nums[b2] + nums[b1]);
			}
			return nums[b3] + nums[b1];
		} else
			return nums[b3] + nums[b2];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
