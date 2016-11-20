package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * Created by samy on 11/18/16.
 */
public class MinimumMovestoEqualArrayElements {

  /**
   * formula: sum(n) - min(n) * length(n), where n is an integer array
   * @param nums
   * @return
   */
  public int minMoves(int[] nums) {
    int sum = nums[0], min=nums[0];
    for(int i=1; i<nums.length; ++i) {
      sum += nums[i];
      min = Math.min(min, nums[i]);
    }
    return sum - min * nums.length;
  }
}
