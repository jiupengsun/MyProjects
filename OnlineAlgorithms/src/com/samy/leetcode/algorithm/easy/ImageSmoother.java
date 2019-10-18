package com.samy.leetcode.algorithm.easy;

public class ImageSmoother {

  public int[][] imageSmoother(int[][] M) {
    int row = M.length;
    if (row == 0)
      return new int[][]{};
    int col = M[0].length;
    int[][] gray = new int[row][col];
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        int up = i == 0 ? i : i - 1;
        int left = j == 0 ? j : j - 1;
        int right = j == col - 1 ? j : j + 1;
        int down = i == row - 1 ? i : i + 1;
        int sum = 0;
        int count = 0;
        for (int m = up; m <= down; ++m) {
          for (int n = left; n <= right; ++n) {
            sum += M[m][n];
            ++count;
          }
        }
        gray[i][j] = sum / count;
      }
    }
    return gray;
  }
}
