package com.samy.leetcode.algorithm.hard;

public class LongestIncreasingPathinaMatrix {

  /**
   * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
   *
   * @param matrix
   * @return
   */
  private final int[][] direct = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int longestIncreasingPath(int[][] matrix) {
    int max = 0;
    int row = matrix.length;
    if (row == 0)
      return max;
    int col = matrix[0].length;
    if (col == 0)
      return max;
    int[][] max_path = new int[row][col];
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (max_path[i][j] == 0)
          DFS(matrix, i, j, max_path);
        max = Math.max(max, max_path[i][j]);
      }
    }
    return max;
  }

  /**
   * if using normal DFS, it will cause TLE
   * using max_path to prune
   *
   * @param matrix
   * @param p
   * @param q
   * @param max_path
   */
  private void DFS(int[][] matrix, int p, int q, int[][] max_path) {
    if (max_path[p][q] > 0)
      return;
    int max = 0;
    for (int[] d : direct) {
      int i = Math.max(0, Math.min(matrix.length - 1, p + d[0]));
      int j = Math.max(0, Math.min(matrix[0].length - 1, q + d[1]));
      if (matrix[i][j] > matrix[p][q]) {
        DFS(matrix, i, j, max_path);
        max = Math.max(max, max_path[i][j]);
      }
    }
    max_path[p][q] = max + 1;
  }
}
