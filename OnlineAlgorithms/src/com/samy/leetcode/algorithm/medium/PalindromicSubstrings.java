package com.samy.leetcode.algorithm.medium;

public class PalindromicSubstrings {

  /**
   * https://leetcode.com/problems/palindromic-substrings/description/
   * @param s
   * @return
   */
  public int countSubstrings(String s) {
    int length = s.length();
    if(length == 0)
      return 0;
    int[][] dp = new int[length][length];
    for(int j=0; j<length; ++j) {
      dp[j][j] = 1;
      for(int i=j-1; i>=0; --i) {
        dp[i][j] = Math.abs(dp[i][j-1]) + Math.abs(dp[i+1][j]) - Math.abs(dp[i+1][j-1]);
        if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>=0) {
          // [i,j] is palindromic
          dp[i][j]++;
        } else
          dp[i][j] = -dp[i][j];
      }
    }
    return Math.abs(dp[0][length-1]);
  }

  public int countSubstrings2(String s) {
    int length = s.length();
    if(length == 0)
      return 0;
    boolean[][] dp = new boolean[length][length];
    int count = 0;
    for(int j=0; j<length; ++j) {
      dp[j][j] = true;
      ++count;
      for(int i=j-1; i>=0; --i) {
        if(s.charAt(i)==s.charAt(j) && (i==j-1 || dp[i+1][j-1])) {
          // [i,j] is palindromic
          dp[i][j] = true;
          ++count;
        }
      }
    }
    return count;
  }
}
