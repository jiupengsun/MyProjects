package com.samy.leetcode.algorithm.easy;

public class ThirdMaximumNumber {

  /**
   * https://leetcode.com/problems/third-maximum-number/description/
   *
   * @param nums
   * @return
   */
  public int thirdMax(int[] nums) {
    Integer[] max = new Integer[4];
    for (int i : nums) {
      int j = 2;
      while (j >= 0 && (max[j] == null || max[j] < i))
        --j;
      if (j >= 0 && max[j] != null && max[j] == i)
        continue;
      ++j;
      if (j < 3) {
        int k = 2;
        while (k >= j) {
          max[k + 1] = max[k];
          --k;
        }
        max[j] = i;
      }
    }
    return max[2] == null ? max[0] : max[2];
  }
}
