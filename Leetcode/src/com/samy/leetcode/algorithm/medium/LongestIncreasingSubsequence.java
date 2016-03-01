package com.samy.leetcode.algorithm.medium;

public class LongestIncreasingSubsequence {

	/**
	 * 
	 * @param nums
	 * @return
	 * 2016Äê3ÔÂ1ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/longest-increasing-subsequence/
	 * @interpretation
	 */
	public int lengthOfLIS(int[] nums) {
		int l = nums.length;
		int[] inc = new int[l];
		int i = 1, j = 0, max = 0;
		//out of considering zero
		inc[0] = nums[0];
		while (i < l) {
			if (nums[i] > nums[i - 1]) {
				inc[++j] = nums[i++];
				max = j > max ? j : max;
			} else {
				while (j >= 0 && inc[j] > nums[i])
					--j;
				inc[++j] = nums[i++];
			}
		}
		return max + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
		System.out.println(ls.lengthOfLIS(nums));
	}

}
