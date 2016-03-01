package com.samy.leetcode.algorithm.medium;

public class LongestIncreasingSubsequence {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ1ÈÕ
	 * @author Jiupeng
	 * @description 22 test cases, 1ms beats 86.18%
	 * @reference https://leetcode.com/problems/longest-increasing-subsequence/
	 * @interpretation
	 */
	public int lengthOfLIS(int[] nums) {
		int l = nums.length;
		int[] inc = new int[l + 1];
		inc[0] = Integer.MIN_VALUE;
		int i = 0, j = 0, max = 0;
		while (i < l) {
			if (nums[i] > inc[max]) {
				inc[++max] = nums[i++];
				j = max;
			} else {
				while (inc[j] > nums[i])
					--j;
				inc[++j] = nums[i++];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
		System.out.println(ls.lengthOfLIS(nums));
	}

}
