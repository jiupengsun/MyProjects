package com.samy.leetcode.algorithm.easy;

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
		return robDP(nums, 0);
	}

	private int robDP(int[] nums, int st) {
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
		default: {
			// if n[1] >= n[2], pick up n[1]
			if (nums[st] >= nums[st + 1])
				return nums[st] + robDP(nums, st + 2);
			else {
				// if n[1] < n[2] && n[1]+n[3] < n[2], pick up n[2]
				if (nums[st] + nums[st + 2] < nums[st + 1])
					return nums[st + 1] + robDP(nums, st + 3);
				else
					// else, compare n[1]+f(3) and n[2]+f(4), pick up the bigger one
					return Math.max(nums[st] + robDP(nums, st + 2), nums[st + 1] + robDP(nums, st + 3));
			}
		}
		}
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月16日
	 * @author Jiupeng
	 * @description 69cases 1ms
	 * @reference
	 */
	public int robSample(int[] nums) {
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
		default: {
			int[] rob = new int[nums.length];
			rob[0] = nums[0];
			rob[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < nums.length; ++i) {
				rob[i] = Math.max(rob[i - 1], nums[i] + rob[i - 2]);
			}
			return rob[nums.length - 1];
		}
		}
	}

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016年1月16日
	 * @author Jiupeng
	 * @description 69cases 0ms
	 * @reference
	 */
	public int robSample2(int[] nums) {
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
		default: {
			int i = 2, current = 0, preTwo = nums[0], preOne = Math.max(nums[0], nums[1]);
			while (i < nums.length) {
				current = Math.max(nums[i++] + preTwo, preOne);
				preTwo = preOne;
				preOne = current;
			}
			return current;
		}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90,
				222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241,
				202, 144, 240 };
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.robSample2(n));
	}

}
