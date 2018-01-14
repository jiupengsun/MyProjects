package com.samy.company.Linkedin;

public class MaxPalindromeSequence {

  public int longestPalindrome(String s) {
    int length = s.length();
    if(length == 0)
      return 0;
    int[][] dp = new int[length][length];
    for(int j=0; j<length; ++j) {
      dp[j][j] = 1;
      for(int i=j-1; i>=0; --i) {
        if(s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i+1][j-1] + 2;
        } else
          dp[i][j] = Math.max(dp[i+1][j-1], Math.max(dp[i][j-1], dp[i+1][j]));
      }
    }
    return dp[0][length-1];
  }

  public static void main(String[] args) {
    MaxPalindromeSequence mp = new MaxPalindromeSequence();
    System.out.println(mp.longestPalindrome("hcelleaho"));
  }
}
