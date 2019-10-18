package com.samy.company.chinalife;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by samy on 11/5/16.
 */
public class Sudoku {

  private final static char tile[] = new char[]{'W', 'E', 'T', 'U', 'D', 'H', 'X', 'B', 'M'};

  public static String[] coverFloor(String[] f) {
    char[][] floor = new char[9][9];
    int i = 0, j = 0;
    for (i = 0; i < 9; ++i) {
      floor[i] = f[i].toCharArray();
    }

    for (i = 0; i < 9; ++i) {
      for (j = 0; j < 9; ++j) {
        if (floor[i][j] == 'O') {
          break;
        }
      }
      if (j < 9)
        break;
    }

    DP(floor, i, j);

    for (i = 0; i < 9; ++i)
      f[i] = new String(floor[i]);
    return f;
  }

  private static boolean check(char[][] board, int p, int q, char c) {
    // check row
    for (int i = p, j = 0; j < 9; ++j)
      if (board[i][j] == c)
        return false;
    // check column
    for (int i = 0, j = q; i < 9; ++i)
      if (board[i][j] == c)
        return false;
    // check 9*9
    for (int i = p / 3 * 3, row = (p / 3 + 1) * 3; i < row; ++i)
      for (int j = q / 3 * 3, col = (q / 3 + 1) * 3; j < col; ++j)
        if (board[i][j] == c)
          return false;

    return true;
  }

  private static void DP(char[][] board, int first_i, int first_j) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{first_i, first_j, -1});
    while (!stack.isEmpty()) {
      int[] s = stack.pop();
      int i = s[0], j = s[1], k = ++s[2];
      board[i][j] = 'O';
      // find the first empty
      for (; i < 9; ++i, j = 0) {
        for (; j < 9; ++j) {
          if (board[i][j] != 'O')
            continue;
          for (; k < 9; ++k) {
            char c = tile[k];
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

      if (i == 9) {
        return;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Queue<String[]> floor = new LinkedList<>();
    int testcase = Integer.parseInt(in.nextLine());
    for (int i = 0; i < testcase; ++i) {
      String[] f = new String[9];
      for (int j = 0; j < 9; ++j) {
        f[j] = in.nextLine();
      }
      floor.add(coverFloor(f));
      in.nextLine();
    }

    for (int j = 0; j < testcase; ++j) {
      String[] f = floor.poll();
      for (String s : f)
        System.out.println(s);
      System.out.println();
    }
  }
}
