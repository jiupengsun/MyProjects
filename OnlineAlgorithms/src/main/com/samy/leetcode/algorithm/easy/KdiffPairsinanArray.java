package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray {

  /**
   * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
   *
   * @param nums
   * @param k
   * @return
   */
  public int findPairs(int[] nums, int k) {
    if (k < 0)
      return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int n : nums) {
      if (k == 0) {
        int c = map.getOrDefault(n, 0);
        if (c == 1) {
          ++count;
        }
        map.put(n, ++c);
      } else {
        if (map.containsKey(n))
          continue;
        if (map.containsKey(n - k))
          ++count;
        if (map.containsKey(n + k))
          ++count;
        map.put(n, 1);
      }
    }
    return count;
  }
}
