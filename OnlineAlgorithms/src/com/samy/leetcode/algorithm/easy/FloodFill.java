package com.samy.leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
  private final int[][] direct = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    // BFS
    int row = image.length, col = image[0].length;
    Queue<int[]> que = new LinkedList<>();
    boolean[][] visit = new boolean[row][col];
    int ori = image[sr][sc];
    if(ori != newColor)
      que.add(new int[]{sr, sc});
    while(!que.isEmpty()) {
      int[] pos = que.poll();
      if(visit[pos[0]][pos[1]])
        continue;
      visit[pos[0]][pos[1]] = true;
      image[pos[0]][pos[1]] = newColor;
      // check four directions
      for(int[] d: direct) {
        int i = Math.max(0, Math.min(pos[0]+d[0], row-1));
        int j = Math.max(0, Math.min(pos[1]+d[1], col-1));
        if(!visit[i][j] && image[i][j]==ori)
          que.add(new int[]{i, j});
      }
    }
    return image;
  }
}
