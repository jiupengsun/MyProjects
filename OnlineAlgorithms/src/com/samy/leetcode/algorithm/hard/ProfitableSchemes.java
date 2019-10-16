package com.samy.leetcode.algorithm.hard;

/**
 * <a href="https://leetcode.com/problems/profitable-schemes/">Profitable Schemes</a>
 */
public class ProfitableSchemes {
  // TODO not done yet
  /**
   * DP, 3 dimension
   * i, j, k represents G, P, the index of group/profit, so we have
   * C(i, j, k) equals:
   *  1) if (group[k] > i) C(i, j, k+1) since we can't take item k
   *  2) else C(i, j, k+1)+C(i-group[k], Math.max(0, j-profit[k], k+1))
   * when j=0, C(;j;index-1) = 1
   */
  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    int length = group.length;
    int[][][] dp = new int[G][P][length];
    // initialization for the last element
    for (int i=0, k=length-1; i<G; ++i) {
      for (int j=0; j<P; ++j) {
        // suppose we have only one item, then
        // if profit is zero, OR
        // the group of this item is smaller than or equal to G AND
        // the profit of this item is larger than or equal to P
        // then we can take it
        if (j == 0 || group[k] <= i && profit[k] >= j) {
          dp[i][j][k] = 1;
        }
      }
    }
    for (int i=0; i<G; ++i) {
      for (int j=0; j<P; ++j) {
        for (int k=length-2; k>-1; --k) {
          if (group[k] > i) {
            dp[i][j][k] = dp[i][j][k+1];
          } else {
            dp[i][j][k] = dp[i][j][k+1] + dp[i-group[k]][Math.max(0, j-profit[k])][k+1];
          }
        }
      }
    }
    // dp[G-1][P-1][0] is the final result
    return dp[G-1][P-1][0] % 1000000007;
  }

  public static void main(String[] args) {
    ProfitableSchemes p = new ProfitableSchemes();
    int G = 10;
    int P = 5;
    int[] group = new int[]{2, 3, 5};
    int[] profit = new int[]{6, 7, 8};
    int result = p.profitableSchemes(G, P, group, profit);
    System.out.println(result);
  }
}
