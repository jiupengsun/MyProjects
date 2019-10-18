package com.samy.leetcode.algorithm.hard;

public class FirstMissingPositive {

  /**
   * https://leetcode.com/problems/first-missing-positive/description/
   *
   * @param nums
   * @return
   */
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == i + 1)
        continue;
      int tmp = nums[i];
      nums[i] = 0;
      while (tmp > 0 && tmp <= nums.length) {
        int t = nums[tmp - 1];
        if (tmp == t)
          break;
        nums[tmp - 1] = tmp;
        tmp = t;
      }
    }
    int j = 1;
    for (int i = 0; i < nums.length; ++i, ++j) {
      if (nums[i] != j)
        break;
    }
    return j;
  }
}
