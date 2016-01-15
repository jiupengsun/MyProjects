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
		return 0;
	}

	public int robTooSlow(int[] nums) {
		return robSub(nums, 0);
	}

	private int robSub(int[] nums, int st) {
		int d = nums.length - st;
		switch (d) {
		case 0: {
			return 0;
		}
		case 1: {
			return nums[st];
		}
		case 2: {
			return Math.max(nums[st], nums[st + 1]);
		}
		case 3: {
			return Math.max(nums[st + 1], nums[st + 0] + nums[st + 2]);
		}
		case 4: {
			return Math.max(nums[st] + nums[st + 2], nums[st + 1] + nums[st + 3]);
		}
		default: {
			return Math.max(nums[st] + robSub(nums, st + 2), robSub(nums, st + 1));
		}
		}
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
		int[] n = { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91,
				80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114,
				235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169,
				241, 202, 144, 240 };
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(n));
	}

}
