package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/description/
 */
public class DesignTicTacToe {
  int[][] board;
  boolean flag;
  int size;

  /** Initialize your data structure here. */
  public DesignTicTacToe(int n) {
    board = new int[n][n];
    flag = true;
    size = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    if(board[row][col] == 0) {
      board[row][col] = player==1 ? 1 : -1;
      int target = board[row][col];
      // row
      int j = 0;
      for(; j<size; ++j)
        if(target != board[row][j])
          break;
      if(j == size)
        return player;
      // col
      int i = 0;
      for(; i<size; ++i)
        if(target != board[i][col])
          break;
      if(i == size)
        return player;
      // right diagonal
      if(row == col) {
        for(i=0, j=0; i<size; ++i, ++j)
          if(target != board[i][j])
            break;
        if(i==size)
          return player;
      }
      // left diagonal
      if(row==size-1 && col==0 || row==0 && col==size-1 || row==col) {
        for(i=size-1, j=0; i>=0; --i, ++j)
          if(target != board[i][j])
            break;
        if(i < 0)
          return player;
      }
    }
    return 0;
  }
}
