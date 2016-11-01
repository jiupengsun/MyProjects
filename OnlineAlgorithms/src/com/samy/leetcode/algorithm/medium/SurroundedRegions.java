package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * Created by samy on 10/31/16.
 */
public class SurroundedRegions {

  public void solve2(char[][] board) {
    int row = board.length;
    int col = row > 0 ? board[0].length : 0;
    if(row==0 || col==0)
      return;
    boolean[][] visited = new boolean[row][col];
    List<Integer[]> color = new ArrayList<>(row * col);
    for(int i=0; i<row; ++i)
      for(int j=0; j<col; ++j) {
        if(board[i][j] == 'X' || visited[i][j])
          continue;
        // 'O' and not visited
        if(!DFS2(board, row, col, i, j, visited, color)) {
          for(Integer[] loc : color) {
            board[loc[0]][loc[1]] = 'X';
          }
        }
        color = new ArrayList<>(row * col);
      }
  }


  public void solve(char[][] board) {
    int row = board.length;
    int col = row > 0 ? board[0].length : 0;
    if(row==0 || col==0)
      return;
    boolean[][] visited = new boolean[row][col];
    for(int i=0, j=0; i<row; ++i)
      if(board[i][j] == 'O')
        DFS(board, row, col, i, j, visited);

    for(int i=row-1, j=1; j<col; ++j)
      if(board[i][j] == 'O')
        DFS(board, row, col, i, j, visited);

    for(int i=row-1, j=col-1; i>=0; --i)
      if(board[i][j] == 'O')
        DFS(board, row, col, i, j, visited);

    for(int i=0, j=col-1; j>0; --j)
      if(board[i][j] == 'O')
        DFS(board, row, col, i, j, visited);

    for(int i=0; i<row; ++i)
      for(int j=0; j<col; ++j)
        if(!visited[i][j])
          board[i][j] = 'X';
  }

  public void DFS(char[][] board, int row, int col, int i, int j, boolean[][] visited) {
    Stack<Integer[]> stack = new Stack<>();
    stack.push(new Integer[]{i, j});
    while(!stack.isEmpty()) {
      Integer[] pos = stack.pop();
      i = pos[0];
      j = pos[1];
      if(!visited[i][j]) {
        visited[i][j] = true;

        // left
        if(j>0 && board[i][j-1]=='O')
          stack.push(new Integer[]{i, j-1});
        // bottom
        if(i<row-1 && board[i+1][j]=='O')
          stack.push(new Integer[]{i+1, j});
        // right
        if(j<col-1 && board[i][j+1]=='O')
          stack.push(new Integer[]{i, j+1});
        // up
        if(i>0 && board[i-1][j]=='O')
          stack.push(new Integer[]{i-1, j});
      }
    }
  }

  /*
  pesudocode
  recursive version:
  void DFS(G, V) {
   set V as visited
   for w in G:
    // w is edge node of V
    if(w is not visited)
      DFS(w, G)
  }

  non-recursive version:
  void DFS(G, V) {
    let S be a stack
    S.push(V)
    while(S is not empty) {
      v = S.pop()
      if (v is not visited)
        set v as visited
        for w in G:
        // w is edge node of v
          S.push(w)
    }
  }
   */

  private boolean DFS2(char[][] board, int row, int col, int i, int j, boolean[][] visited, List<Integer[]> color) {
    boolean flag = false;
    Stack<Integer[]> pos = new Stack<>();
    pos.push(new Integer[]{i, j});
    while(!pos.isEmpty()) {
      Integer[] p = pos.pop();
      i = p[0];
      j = p[1];
      if(!visited[i][j]) {
        visited[i][j] = true;
        color.add(new Integer[]{i, j});
        // not visited
        // left
        if( j==0 )
          flag = true;
        else if(board[i][j-1] == 'O')
          pos.push(new Integer[]{i, j-1});

        // up
        if( i==0 )
          flag = true;
        else if(board[i-1][j] == 'O')
          pos.push(new Integer[]{i-1, j});

        // right
        if( j==col-1 )
          flag = true;
        else if(board[i][j+1] == 'O')
          pos.push(new Integer[]{i, j+1});

        // bottom
        if( i==row-1 )
          flag = true;
        else if(board[i+1][j] == 'O')
          pos.push(new Integer[]{i+1, j});
      }
    }

    return flag;

  }

  /*
  private boolean DFS2(char[][] board, int row, int col, int i, int j, boolean[][] visited, List<Integer[]> color) {
    boolean flag = false;
    visited[i][j] = true;
    color.add(new Integer[]{i, j});

    // left
    if( j==0 )
      flag |= true;
    else if(board[i][j-1] == 'O' && !visited[i][j-1])
      flag |= DFS(board, row, col, i, j-1, visited, color);

    // up
    if( i==0 )
      flag |= true;
    else if(board[i-1][j] == 'O' && !visited[i-1][j])
      flag |= DFS(board, row, col, i-1, j, visited, color);

    // right
    if( j==col-1 )
      flag |= true;
    else if(board[i][j+1] == 'O' && !visited[i][j+1])
      flag |= DFS(board, row, col, i, j+1, visited, color);

    // bottom
    if( i==row-1 )
      flag |= true;
    else if(board[i+1][j] == 'O' && !visited[i+1][j])
      flag |= DFS(board, row, col, i+1, j, visited, color);

    return flag;

  }
  */

  public static void main(String[] args) {
    String[] chessString = {"OOO","OOO","OOO"};
    int length = chessString.length;
    char[][] chess = new char[length][length];
    for(int i=0; i<length; i++) {
      chess[i] = chessString[i].toCharArray();
    }

    SurroundedRegions sr = new SurroundedRegions();
    sr.solve(chess);
    for(char[] ci : chess) {
      for(char cj : ci)
        System.out.print(cj + " ");
      System.out.println();
    }
  }

}
