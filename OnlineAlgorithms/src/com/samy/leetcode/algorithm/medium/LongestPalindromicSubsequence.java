package com.samy.leetcode.algorithm.medium;

public class LongestPalindromicSubsequence {

  /**
   * https://leetcode.com/problems/longest-palindromic-subsequence/description/
   * @param s
   * @return
   */
  public int longestPalindromeSubseq(String s) {
    int l = s.length();
    if(l == 0)
      return 0;
    int[][] dp = new int[l][l];
    for(int j=0; j<l; ++j) {
      dp[j][j] = 1;
      for(int i=j-1; i>=0; --i) {
        if(s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i+1][j-1] + 2;
        } else
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
      }
    }
    return dp[0][l-1];
  }
}
