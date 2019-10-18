package com.samy.leetcode.algorithm.easy;

public class ReshapetheMatrix {
  /**
   * https://leetcode.com/problems/reshape-the-matrix/description/
   *
   * @param nums
   * @param r
   * @param c
   * @return
   */
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    int row = nums.length;
    if (row == 0)
      return nums;
    int col = nums[0].length;
    if (r <= 0 || c <= 0 || row * col != r * c)
      return nums;
    int m = 0, n = 0;
    int[][] res = new int[r][c];
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j, ++n) {
        if (n == col) {
          m++;
          n = 0;
        }
        res[i][j] = nums[m][n];
      }
    }
    return res;
  }
}
