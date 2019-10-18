package com.samy.leetcode.algorithm.medium;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZeroOneMatrix {

  /**
   * https://leetcode.com/problems/01-matrix/description/
   *
   * @param matrix
   * @return
   */
  int[][] direction = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int[][] updateMatrix(int[][] matrix) {
    int row = matrix.length;
    if (row == 0)
      return new int[][]{};
    int col = matrix[0].length;
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (matrix[i][j] == 1)
          matrix[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (matrix[i][j] > 0)
          continue;
        boolean[][] visit = new boolean[row][col];
        Dijkstra(matrix, i, j, visit);
      }
    }
    return matrix;
  }

  /**
   * TLE
   *
   * @param matrix
   * @param m
   * @param n
   * @param visit
   */
  private void Dijkstra(final int[][] matrix, int m, int n, boolean[][] visit) {
    PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        return matrix[i1[0]][i1[1]] - matrix[i2[0]][i2[1]];
      }
    });
    que.add(new int[]{m, n});
    while (!que.isEmpty()) {
      int[] pos = que.poll();
      visit[pos[0]][pos[1]] = true;
      for (int k = 0; k < 4; ++k) {
        int i = Math.max(0, Math.min(pos[0] + direction[k][0], matrix.length - 1));
        int j = Math.max(0, Math.min(pos[1] + direction[k][1], matrix[0].length - 1));
        if (!visit[i][j] && matrix[i][j] > 0 && matrix[i][j] > matrix[pos[0]][pos[1]] + 1) {
          matrix[i][j] = matrix[pos[0]][pos[1]] + 1;
          que.add(new int[]{i, j});
        }
      }
    }
  }

  /**
   * BFS
   *
   * @param matrix
   * @return
   */
  public int[][] updateMatrix2(int[][] matrix) {
    int row = matrix.length;
    if (row == 0)
      return new int[][]{};
    int col = matrix[0].length;
    Queue<int[]> que = new LinkedList<>();
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (matrix[i][j] == 0)
          que.add(new int[]{i, j});
        else
          matrix[i][j] = Integer.MAX_VALUE;
      }
    }
    while (!que.isEmpty()) {
      int[] pos = que.poll();
      for (int k = 0; k < 4; ++k) {
        int i = Math.max(0, Math.min(matrix.length - 1, pos[0] + direction[k][0]));
        int j = Math.max(0, Math.min(matrix[0].length - 1, pos[1] + direction[k][1]));
        if (matrix[i][j] > matrix[pos[0]][pos[1]] + 1) {
          matrix[i][j] = matrix[pos[0]][pos[1]] + 1;
          que.add(new int[]{i, j});
        }
      }
    }
    return matrix;
  }
}
