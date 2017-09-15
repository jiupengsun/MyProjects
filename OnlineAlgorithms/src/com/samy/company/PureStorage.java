package com.samy.company;

public class PureStorage {

  static int count_palindromes(String S) {
    int length = S.length();
    int[][] dp = new int[length][length];
    for(int j=0; j<length; ++j) {
      dp[j][j] = 1;
      for(int i=j-1; i>=0; --i) {
        int n = Math.abs(dp[i][j-1])+Math.abs(dp[i+1][j])-Math.abs(dp[i+1][j-1]);
        if(S.charAt(i)==S.charAt(j) && dp[i+1][j-1]>=0) {
          dp[i][j] = n + 1;
        } else {
          dp[i][j] = -n;
        }
      }
    }
    return Math.abs(dp[0][length-1]);
  }

  public static void main(String[] args) {
    System.out.println(count_palindromes("hellolle"));
  }
}
