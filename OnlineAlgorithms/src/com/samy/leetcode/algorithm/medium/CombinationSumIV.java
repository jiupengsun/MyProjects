package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class CombinationSumIV {

  /**
   * https://leetcode.com/problems/combination-sum-iv/description/
   * @param nums
   * @param target
   * @return
   */
  public int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for(int i=1; i<=target; ++i) {
      int sum = 0;
      for(int j=0; j<nums.length && nums[j]<=i; ++j)
        sum += dp[i - nums[j]];
      dp[i] = sum;
    }
    return dp[target];
  }

  public static void main(String[] args) {
    CombinationSumIV cs = new CombinationSumIV();
    System.out.println(cs.combinationSum4(new int[]{1,2,3}, 4));
  }
}
