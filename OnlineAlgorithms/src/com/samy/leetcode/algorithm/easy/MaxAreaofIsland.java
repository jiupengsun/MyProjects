package com.samy.leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {
  /**
   * https://leetcode.com/problems/max-area-of-island/description/
   */
  private final int[][] direct = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int maxAreaOfIsland(int[][] grid) {
    int row = grid.length;
    if(row == 0)
      return 0;
    int col = grid[0].length;
    int max = 0;
    boolean[][] visit = new boolean[row][col];
    for(int i=0; i<row; ++i) {
      for(int j=0; j<col; ++j) {
        if(grid[i][j] == 1) {
          max = Math.max(max, BFS(grid, i, j, visit));
        }
      }
    }
    return max;
  }

  private int BFS(int[][] grid, int m, int n, boolean[][] visit) {
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{m, n});
    int area = 0;
    while(!que.isEmpty()) {
      int[] p = que.poll();
      if(visit[p[0]][p[1]])
        continue;
      visit[p[0]][p[1]] = true;
      area++;
      for(int[] d: direct) {
        int i = Math.max(0, Math.min(p[0]+d[0], grid.length-1));
        int j = Math.max(0, Math.min(p[1]+d[1], grid[0].length-1));
        if(!visit[i][j] && grid[i][j]==1)
          que.add(new int[]{i, j});
      }
    }
    return area;
  }
}
