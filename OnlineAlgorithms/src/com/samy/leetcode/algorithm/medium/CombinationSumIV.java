package com.samy.leetcode.algorithm.medium;

public class CombinationSumIV {

  /**
   * https://leetcode.com/problems/combination-sum-iv/description/
   * @param nums
   * @param target
   * @return
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for(int i=1; i<=target; ++i) {
      int sum = 0;
      for(int n: nums) {
        if(n <= i) {
          sum += dp[i - n];
        }
      }
      dp[i] = sum;
    }
    return dp[target];
  }

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
  }
}
