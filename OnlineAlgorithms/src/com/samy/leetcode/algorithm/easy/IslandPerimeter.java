package com.samy.leetcode.algorithm.easy;

import java.util.Deque;
import java.util.LinkedList;

public class IslandPerimeter {
  private final int[][] direct = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int islandPerimeter(int[][] grid) {
    int row = grid.length;
    if(row == 0)
      return 0;
    int col = grid[0].length;
    for(int i=0; i<row; ++i) {
      for(int j=0; j<col; ++j) {
        if(grid[i][j] == 1)
          return DFS(grid, i, j);
      }
    }
    return 0;
  }

  private int DFS(int[][] grid, int i, int j) {
    boolean[][] visit = new boolean[grid.length][grid[0].length];
    Deque<int[]> stack = new LinkedList<>();
    stack.push(new int[]{i, j});
    int peri = 0;
    while(!stack.isEmpty()) {
      int[] p = stack.pop();
      if(visit[p[0]][p[1]])
        continue;
      visit[p[0]][p[1]] = true;
      // check peri
      for(int[] d: direct) {
        int m = p[0] + d[0];
        int n = p[1] + d[1];
        if(m<0 || m==grid.length || n<0 || n==grid[0].length || grid[m][n]==0)
          peri++;
        m = Math.max(0, Math.min(m, grid.length-1));
        n = Math.max(0, Math.min(n, grid[0].length-1));
        if(!visit[m][n] && grid[m][n] == 1) {
          // a new block
          stack.push(new int[]{m, n});
        }
      }
    }
    return peri;
  }
}
