package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
  /**
   * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/
   *
   * @param nums
   * @param k
   * @return
   */
  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, max = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      int diff = sum - k;
      if (map.containsKey(diff))
        max = Math.max(max, i - map.get(diff));
      map.put(sum, Math.min(map.getOrDefault(sum, i), i));
    }
    return max;
  }
}
