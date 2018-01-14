package com.samy.leetcode.algorithm.easy;

public class MaxConsecutiveOnes {
  /**
   * https://leetcode.com/problems/max-consecutive-ones/description/
   * @param nums
   * @return
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    int last = -1, max = 0, i = 0;
    for(; i<nums.length; ++i) {
      if(nums[i] == 0) {
        int length = i - last - 1;
        max = Math.max(max, length);
        last = i;
      }
    }
    return Math.max(max, i-last-1);
  }
}
