package com.samy.leetcode.algorithm.hard;

/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable/description/
 */
public class RangeSumQuery2DMutable {
}

class NumMatrix {
  int[][] tree;
  int[][] nums;
  int row, col;

  public NumMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return;
    row = matrix.length;
    col = matrix[0].length;
    tree = new int[row + 1][col + 1];
    nums = new int[row][col];
    for (int i = 1; i <= row; ++i) {
      for (int j = 1; j <= col; ++j) {
        updateTree(i, j, matrix[i - 1][j - 1]);
      }
    }
  }

  private void updateTree(int m, int n, int val) {
    int diff = val - nums[m - 1][n - 1];
    nums[m - 1][n - 1] = val;
    for (int i = m; i <= row; i += (i & (-i))) {
      for (int j = n; j <= col; j += (j & (-j))) {
        tree[i][j] += diff;
      }
    }
  }

  public void update(int row, int col, int val) {
    updateTree(row + 1, col + 1, val);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row2 + 1, col1) - sum(row1, col2 + 1);
  }

  private int sum(int m, int n) {
    int sum = 0;
    for (int i = m; i > 0; i -= i & (-i)) {
      for (int j = n; j > 0; j -= j & (-j))
        sum += tree[i][j];
    }
    return sum;
  }
}
