package com.samy.leetcode.algorithm.easy;

public class MaximumSubarray {

  /**
   * https://leetcode.com/problems/maximum-subarray/description/
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = dp[0];
    for(int i = 1; i < n; i++){
      dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
      max = Math.max(max, dp[i]);
    }

    return max;

  }
}
