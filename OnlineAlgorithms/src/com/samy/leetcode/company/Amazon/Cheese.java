package com.samy.leetcode.company.Amazon;

/**
 * Created by samy on 10/30/16.
 */
public class Cheese {

  public static boolean isReachable(int[][] maze) {
    int row_length = maze.length;
    if (row_length <= 0)
      return false;
    int col_length = maze[0].length;
    int[][] dfs = new int[row_length][col_length];
    return DFS(maze, dfs, 0, 0, row_length, col_length);
  }

  private static boolean DFS(int[][] maze, int[][] dfs, int i, int j, int row, int col) {
    // visit here
    dfs[i][j] = 1;
    if (maze[i][j] == 0)
      return false;
    if (maze[i][j] == 9)
      // reach
      return true;

    // check left
    if (j > 0 && dfs[i][j-1] == 0)
      if (DFS(maze, dfs, i, j-1, row, col))
        return true;
    // check up
    if (i > 0 && dfs[i-1][j] == 0)
      if (DFS(maze, dfs, i-1, j, row, col))
        return true;
    // check right
    if (j < col - 1 && dfs[i][j+1] == 0)
      if (DFS(maze, dfs, i, j+1, row, col))
        return true;
    // check bottom
    if (i < row - 1 && dfs[i+1][j] == 0)
      if (DFS(maze, dfs, i+1, j, row, col))
        return true;
    // all directions failed
    return false;
  }

  public static void main(String[] args) {
    int maze[][] = {
        {1, 0, 1, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 1, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 1, 0, 9, 0, 1, 1},
        {1, 1, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1}
    };

    Cheese c = new Cheese();
    System.out.println(c.isReachable(maze));
  }
}
