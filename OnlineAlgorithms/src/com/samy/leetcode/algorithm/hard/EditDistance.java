package com.samy.leetcode.algorithm.hard;

public class EditDistance {

  /**
   * https://leetcode.com/problems/edit-distance/description/
   *
   * @param word1
   * @param word2
   * @return
   * @reference: http://www.cnblogs.com/ivanyb/archive/2011/11/25/2263356.html
   */
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i < dp.length; ++i) {
      dp[i][0] = i;
    }
    for (int j = 0; j < dp[0].length; ++j) {
      dp[0][j] = j;
    }
    for (int i = 1; i < dp.length; ++i) {
      for (int j = 1; j < dp[0].length; ++j) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
}
