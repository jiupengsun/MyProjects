package com.samy.leetcode.algorithm.medium;

public class ValidSudoku {

  /**
   * https://leetcode.com/problems/valid-sudoku/description/
   *
   * @param board
   * @return
   */
  public boolean isValidSudoku(char[][] board) {
    int[] row = new int[board.length];
    int[] col = new int[board.length];
    int[] cell = new int[board.length];
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board.length; ++j) {
        int k = 1 << (board[i][j] - '1');
        if ((row[i] & k) > 0)
          return false;
        row[i] |= k;
        if ((col[i] & k) > 0)
          return false;
        col[j] |= k;
        int p = (i / 3) * 3 + j / 3;
        if ((cell[p] & k) > 0)
          return false;
        cell[p] |= k;
      }
    }
    return true;
  }
}
