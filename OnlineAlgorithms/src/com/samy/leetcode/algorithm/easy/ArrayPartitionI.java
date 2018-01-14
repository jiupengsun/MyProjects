package com.samy.leetcode.algorithm.easy;

import java.util.Arrays;

public class ArrayPartitionI {
  /**
   * https://leetcode.com/problems/array-partition-i/description/
   * @param nums
   * @return
   */
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for(int i=0; i<nums.length; i+=2)
      sum += nums[i];
    return sum;
  }
}
