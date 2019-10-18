package com.samy.leetcode.algorithm.hard;

public class SplitArrayLargestSum {

  /**
   * @param nums
   * @param m
   * @return
   */
  public int splitArray(int[] nums, int m) {
    long total = 0, max = 0;
    for (int n : nums) {
      total += n;
      max = Math.max(max, n);
    }
    if (m == 1)
      return (int) total;
    long low = max, mid;
    while (low <= total) {
      mid = ((total - low) >> 1) + low;
      if (greedy(nums, mid, m))
        low = mid + 1;
      else
        total = mid - 1;
    }
    return (int) low;
  }

  private boolean greedy(int[] nums, long target, int m) {
    int count = 1;
    long total = 0;
    for (int n : nums) {
      total += n;
      if (total > target) {
        total = n;
        if (++count > m)
          return true;
      }
    }
    return false;
  }
}


