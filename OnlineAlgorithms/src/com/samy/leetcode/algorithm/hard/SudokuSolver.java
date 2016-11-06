package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * Created by samy on 11/5/16.
 */
public class SudokuSolver {

  /**
   *
   * @param board
   */
  public void solveSudoku(char[][] board) {
    int i=0, j=0;
    for(; i<9; ++i) {
      for (; j<9; ++j) {
        if (board[i][j] == '.') {
          break;
        }
      }
      if (j < 9)
        break;
    }
    DP(board, i, j);
  }

  private boolean check(char[][] board, int p, int q, char c) {
    // check row
    for(int i=p, j=0; j<9; ++j)
      if(board[i][j] == c)
        return false;
    // check column
    for(int i=0, j=q; i<9; ++i)
      if(board[i][j] == c)
        return false;
    // check 9*9
    for(int i=p/3*3, row=(p/3+1)*3; i<row; ++i)
      for(int j=q/3*3, col=(q/3+1)*3; j<col; ++j)
        if(board[i][j] == c)
          return false;

    return true;
  }

  private void DP(char[][] board, int first_i, int first_j) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{first_i, first_j, -1});
    while(!stack.isEmpty()) {
      int[] s = stack.pop();
      int i=s[0], j=s[1], k=++s[2];
      board[i][j] = '.';
      // find the first empty
      for (; i<9; ++i, j=0) {
        for (; j < 9; ++j) {
          if (board[i][j] != '.')
            continue;
          for (; k < 9; ++k) {
            char c = (char)('1' + k);
            if (check(board, i, j, c)) {
              // not conflict
              board[i][j] = c;
              stack.push(new int[]{i, j, k});
              break;
            }
          }
          if (k == 9) {
            // not find suitable digit, trace back
            break;
          }
          k = 0;
        }
        if (k == 9)
          break;
      }

      if (i==9) {
        return;
      }
    }
  }

  public static void main(String[] args) {
    char[][] board = new char[][] {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };

    SudokuSolver ss = new SudokuSolver();
    ss.solveSudoku(board);
    for(int i=0; i<9; ++i) {
      for (int j = 0; j < 9; ++j)
        System.out.print(board[i][j] + " ");
      System.out.println();
    }
  }
}
