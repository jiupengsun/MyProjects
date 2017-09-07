package com.samy.leetcode.algorithm.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheMazeII {

  /**
   * https://leetcode.com/problems/the-maze-ii/description/
   *
   * Use Dijkstra algorithm: https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
   * @param maze
   * @param start
   * @param destination
   * @return
   */
  public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    boolean[][] visit = new boolean[maze.length][maze[0].length];
    final int[][] path = new int[maze.length][maze[0].length];
    PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return path[o1[0]][o1[1]] - path[o2[0]][o2[1]];
      }
    });
    int[][] direction = new int[][]{
      {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };
    que.add(start);
    while(!que.isEmpty()) {
      int[] next = que.poll();
      int current = path[next[0]][next[1]];
      if(next[0]==destination[0] && next[1]==destination[1])
        return current;
      visit[next[0]][next[1]] = true;
      for(int i=0; i<4; ++i) {
        int p = next[0], q = next[1];
        int count = 0;
        while(!isWall(maze, p+direction[i][0], q+direction[i][1])) {
          p += direction[i][0];
          q += direction[i][1];
          count++;
        }
        /**
         * !!!!!!!!!!!!!!!!!!!!!!!
         * Notice I shouldn't update a node if it already has minimum path
         */
        if(!visit[p][q] && (path[p][q]==0 || path[p][q] > current+count)) {
          path[p][q] = current + count;
          que.add(new int[]{p, q});
        }
      }
    }
    return -1;
  }

  private boolean isWall(int[][] maze, int i, int j) {
    return i<0 || j<0 || i==maze.length || j==maze[0].length || maze[i][j]==1;
  }
}
