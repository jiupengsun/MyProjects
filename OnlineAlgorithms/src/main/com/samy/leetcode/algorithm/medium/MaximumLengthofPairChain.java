package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {

  /**
   * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
   *
   * @param pairs
   * @return
   */
  public int findLongestChain(int[][] pairs) {
    if (pairs.length == 0)
      return 0;
    Arrays.sort(pairs, new Comparator<int[]>() {
      @Override
      public int compare(int[] p1, int[] p2) {
        return p1[1] - p2[1];
      }
    });

    int max = pairs[0][1], count = 1;
    for (int i = 1; i < pairs.length; ++i) {
      if (pairs[i][0] > max) {
        ++count;
        max = pairs[i][1];
      }
    }
    return count;

  }
}
