package com.samy.leetcode.algorithm.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * Created by samy on 11/5/16.
 */
public class SudokuSolver {

  public static void main(String[] args) {
    char[][] board = new char[][]{
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
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j)
        System.out.print(board[i][j] + " ");
      System.out.println();
    }
  }

  /**
   * @param board
   */
  public void solveSudoku(char[][] board) {
    int size = board.length;
    int[] row = new int[size];
    int[] col = new int[size];
    int[] cell = new int[size];
    for (int i = 0; i < size; ++i)
      for (int j = 0; j < size; ++j) {
        if (board[i][j] == '.')
          continue;
        int tmp = 1 << (board[i][j] - '0');
        row[i] |= tmp;
        col[j] |= tmp;
        cell[i / 3 * 3 + j / 3] |= tmp;
      }
    helper(board, row, col, cell);
  }

  private void helper(char[][] board, int[] row, int[] col, int[] cell) {
    int size = board.length;
    Deque<int[]> stack = new LinkedList<>();
    int i = 0, j = 0, k = 0;
    // find first empty slot

    for (i = 0; i < size; ++i) {
      for (j = 0; j < size; ++j) {
        if (board[i][j] == '.') {
          break;
        }
      }
      if (j < size)
        break;
    }

    // current pos
    // next valid, if find, put it into stack, then go to next position, loop
    // if not find, pop, or return if stack is empty
    while (i < size && j < size) {
      // current pos
      for (++k; k <= 9; ++k) {
        // find next valid digit
        if (isValid(i, j, k, row, col, cell)) {
          stack.push(new int[]{i, j, k});
          board[i][j] = (char) (k + '0');
          int tmp = 1 << k;
          row[i] |= tmp;
          col[j] |= tmp;
          cell[i / 3 * 3 + j / 3] |= tmp;
          break;
        }
      }
      if (k <= 9) {
        // find, then go to next position
        if (++j >= size) {
          j = 0;
          ++i;
        }
        for (k = 0; i < size; ++i) {
          for (; j < size; ++j) {
            if (board[i][j] == '.')
              break;
          }
          if (j < size)
            break;
          else
            j = 0;
        }
      } else {
        // not find
        // pop if stack isn't empty
        if (stack.isEmpty())
          return;
        int[] last = stack.pop();
        i = last[0];
        j = last[1];
        k = last[2];
        board[i][j] = '.';
        int tmp = ~(1 << k);
        row[i] &= tmp;
        col[j] &= tmp;
        cell[i / 3 * 3 + j / 3] &= tmp;
      }
    }
  }

  private boolean isValid(int i, int j, int k, int[] row, int[] col, int[] cell) {
    int tmp = 1 << k;
    if ((row[i] & tmp) > 0)
      return false;
    if ((col[j] & tmp) > 0)
      return false;
    if ((cell[i / 3 * 3 + j / 3] & tmp) > 0)
      return false;
    return true;
  }
}
