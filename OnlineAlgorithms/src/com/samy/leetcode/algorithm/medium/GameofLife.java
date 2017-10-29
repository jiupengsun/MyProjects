package com.samy.leetcode.algorithm.medium;

public class GameofLife {

  /**
   *
   * @param board
   * 2016��3��4��
   * @author Jiupeng
   * @description 22 test cases, 1ms beats 13.28%
   * @reference https://leetcode.com/problems/game-of-life/
   * @interpretation
   */
  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = m > 0 ? board[0].length : 0;
    int[] next = new int[m * n];
    int l = 0, i, j;
    for (j = 0; j < n; ++j)
      for (i = 0; i < m; ++i) {
        int left = j - 1 > 0 ? j - 1 : 0;
        int right = j + 1 < n - 1 ? j + 1 : n - 1;
        int top = i - 1 > 0 ? i - 1 : 0;
        int bottom = i + 1 < m - 1 ? i + 1 : m - 1;
        int count = 0;
        for (int jt = left; jt <= right; ++jt)
          for (int it = top; it <= bottom; ++it)
            count += board[it][jt];
        if (board[i][j] == 1) {
          //live
          if (count == 3 || count == 4)
            next[l] = 1;
        } else {
          //die
          if (count == 3)
            next[l] = 1;
        }
        ++l;
      }
    for (l = 0, j = 0; j < n; ++j)
      for (i = 0; i < m; ++i)
        board[i][j] = next[l++];
  }

  public void gameOfLife2(int[][] board) {
    for(int i=0; i<board.length; ++i) {
      for(int j=0; j<board[0].length; ++j) {
        int lives = checkLives(board, i, j);
        if(lives<2 || lives>3) {
          board[i][j] &= ~2;
        } else if((board[i][j] & 1)==1 || lives==3) {
            board[i][j] |= 2;
        }
      }
    }
    // move to next state
    for(int i=0; i<board.length; ++i) {
      for(int j=0; j<board[0].length; ++j)
        board[i][j] >>= 1;
    }
  }

  private int checkLives(int[][] board, int i, int j) {
    int row_up = Math.max(0, i-1);
    int row_down = Math.min(board.length-1, i+1);
    int col_left = Math.max(0, j-1);
    int col_right = Math.min(board.length-1, j+1);
    int count = 0;
    for(int m=row_up; m<=row_down; ++m) {
      for(int n=col_left; n<=col_right; ++n) {
        if(m==i && n==j)
          continue;
        if((board[m][n] & 1) == 1)
          ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
