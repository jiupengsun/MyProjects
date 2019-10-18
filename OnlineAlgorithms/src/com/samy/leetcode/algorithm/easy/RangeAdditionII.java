package com.samy.leetcode.algorithm.easy;

public class RangeAdditionII {
  public int maxCount(int m, int n, int[][] ops) {
    int x = m, y = n;
    for (int[] o : ops) {
      x = Math.min(o[0], x);
      y = Math.min(o[1], y);
    }
    return x * y;
  }
}
