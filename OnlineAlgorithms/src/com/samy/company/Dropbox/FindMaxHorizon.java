package com.samy.company.Dropbox;


/**
 * Find max horizon of an image.
 * A horizon is a path from left to right (right, upper diagonal, lower diagonal)
 * with value of min cell on the path. (DP)- Allocate and release IDs.
 * (queue, bitarray, segment tree)
 * https://instant.1point3acres.com/thread/275364
 */
public class FindMaxHorizon {
  public int findMax(int[][] matrix) {
    int max = Integer.MIN_VALUE;
    int[][] dp = new int[matrix.length][matrix[0].length];
    for(int i=0; i<matrix.length; ++i) {
      dp[i][0] = matrix[i][0];
      if(dp[i][0] > max)
        max = dp[i][0];
    }
    for(int j=1; j<matrix[0].length; ++j) {
      for(int i=0; i<matrix.length; ++i) {
        dp[i][j] = matrix[i][j] + Math.max(dp[i][j-1],
          Math.max(
            dp[Math.max(0, i-1)][j-1],// left up
            dp[Math.min(matrix.length-1, i+1)][j-1]// left down
          ));
        if(dp[i][j] > max)
          max = dp[i][0];
      }
    }
    return max;
  }
}
