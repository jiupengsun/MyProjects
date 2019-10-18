package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
  int[][] direc = new int[][]{
    {-1, 0}, {0, -1}, {1, 0}, {0, 1}
  };

  public static void main(String[] args) {
    char[][] m = new char[][]{
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'E', 'S'},
      {'A', 'D', 'E', 'E'}};
    WordSearch ws = new WordSearch();
    ws.exist(m, "ABCESEEEFS");
  }

  public boolean exist(char[][] board, String word) {
    int row = board.length;
    if (row == 0)
      return false;
    int col = board[0].length;
    for (int i = 0; i < row; ++i) {
      for (int j = 0; j < col; ++j) {
        if (board[i][j] == word.charAt(0)) {
          boolean[][] visit = new boolean[row][col];
          if (DFS(board, word, 1, i, j, visit))
            return true;
        }
      }
    }
    return false;
  }

  private boolean DFS(char[][] board, String word, int k, int p, int q, boolean[][] visit) {
    visit[p][q] = true;
    if (k == word.length())
      return true;
    char c = word.charAt(k);
    for (int[] d : direc) {
      int pp = Math.min(board.length - 1, Math.max(0, p + d[0]));
      int qq = Math.min(board[0].length - 1, Math.max(0, q + d[1]));
      if (board[pp][qq] == c && !visit[pp][qq] && DFS(board, word, k + 1, pp, qq, visit))
        return true;
    }
    visit[p][q] = false;
    return false;
  }
}
