package com.samy.leetcode.algorithm.hard;

public class StrangePrinter {

  /**
   * https://leetcode.com/contest/leetcode-weekly-contest-46/problems/strange-printer/
   *
   * @param s
   * @return
   */
  public int strangePrinter(String s) {
    int l = s.length();
    if (l == 0)
      return 0;
    int[][] dp = new int[l][l];
    for (int i = 0; i < l; ++i)
      dp[i][i] = 1;

    for (int j = 1; j < l; ++j) {
      for (int i = j - 1; i >= 0; --i) {
        dp[i][j] = dp[i][j - 1] + 1;
        char c = s.charAt(j);
        for (int k = i; k < j; ++k) {
          if (s.charAt(k) == c) {
            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
          }
        }
      }
    }
    return dp[0][l - 1];
  }
}
