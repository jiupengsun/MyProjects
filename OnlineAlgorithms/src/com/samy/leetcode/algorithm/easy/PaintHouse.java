package com.samy.leetcode.algorithm.easy;

public class PaintHouse {
  /**
   *
   * @param costs
   * @return
   */
  public int minCost(int[][] costs) {
    int length = costs.length;
    if(length == 0)
      return 0;
    for(int i=1; i<costs.length; ++i) {
      costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
      costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
      costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
    }
    return Math.min(costs[length-1][0], Math.min(costs[length-1][1], costs[length-1][2]));

  }
}
