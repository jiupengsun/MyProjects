package com.samy.leetcode.algorithm.medium;

import java.util.Deque;
import java.util.LinkedList;

public class TheMaze {

  /**
   * https://leetcode.com/problems/the-maze/description/
   * @param maze
   * @param start
   * @param destination
   * @return
   */
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int[][] direction = new int[][]{
      {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };
    boolean[][] visit = new boolean[maze.length][maze[0].length];
    Deque<int[]> stack = new LinkedList<>();
    stack.push(start);
    while(!stack.isEmpty()) {
      int[] next = stack.pop();
      if(next[0]==destination[0] && next[1]==destination[1])
        return true;
      visit[next[0]][next[1]] = true;
      // judge
      for(int i=0; i<4; ++i) {
        int p=next[0], q=next[1];
        while(!isWall(maze,p+direction[i][0], q+direction[i][1])) {
          p += direction[i][0];
          q += direction[i][1];
        }
        if(!visit[p][q])
          stack.push(new int[]{p, q});
      }
    }
    return false;
  }

  private boolean isWall(int[][] maze, int p, int q) {
    return p<0 || q<0 || p==maze.length || q==maze[0].length || maze[p][q]==1;
  }
}
