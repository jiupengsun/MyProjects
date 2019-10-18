package com.samy.leetcode.algorithm.hard;

public class PaintHouseII {
  /**
   * https://leetcode.com/problems/paint-house-ii/description/
   *
   * @param costs
   * @return
   */
  public int minCostII(int[][] costs) {
    int length = costs.length;
    if (length == 0)
      return 0;
    int k = costs[0].length;
    int[] min = new int[k];
    for (int i = 0; i < length; ++i) {
      if (i > 0) {
        // calculate costs
        for (int j = 0; j < k; ++j) {
          costs[i][j] += min[j];
        }
      }
      if (i != length - 1) {
        int[] tmp = new int[k];
        min[0] = Integer.MAX_VALUE;
        // record min value on the lef
        for (int j = 1; j < k; ++j) {
          min[j] = Math.min(min[j - 1], costs[i][j - 1]);
        }
        // record max value on the right
        tmp[k - 1] = Integer.MAX_VALUE;
        for (int j = k - 2; j >= 0; --j) {
          tmp[j] = Math.min(tmp[j + 1], costs[i][j + 1]);
        }
        // update min=min(left, right)
        for (int j = 0; j < k; ++j) {
          min[j] = Math.min(min[j], tmp[j]);
        }
      }
    }

    int minCosts = Integer.MAX_VALUE;
    for (int j : costs[length - 1])
      if (minCosts > j)
        minCosts = j;
    return minCosts;
  }
}
