package com.samy.leetcode.algorithm.hard;

/**
 * <a href="https://leetcode.com/problems/profitable-schemes/">Profitable Schemes</a>
 */
public class ProfitableSchemes {
  /**
   * DP, 3 dimension
   * i, j, k represents G, P, the index of group/profit, so we have
   * C(i, j, k) equals:
   *  1) if (group[k] > i) C(i, j, k+1) since we can't take item k
   *  2) else C(i, j, k+1) + C(i-group[k], Math.max(0, j-profit[k]), k+1)
   */
  public int profitableSchemes(int G, int P, int[] group, int[] profit) {
    int mod = 1_000_000_007;
    int length = group.length;
    int[][][] dp = new int[G+1][P+1][length];
    // initialization for the last element
    for (int i=0, k=length-1; i<=G; ++i) {
      // when target profit is 0, no matter if we take the item we can meet the requirement,
      // so we have 2 schemas when group[i] <= target group, otherwise 1
      dp[i][0][k] = group[k] <= i ? 2 : 1;
      for (int j=1; j<=P; ++j) {
        // suppose we have only one item, then if
        // the group[item] is smaller than or equal to G AND
        // the profit[item] is larger than or equal to P
        // we can take it
        if (group[k] <= i && profit[k] >= j) {
          dp[i][j][k] = 1;
        }
      }
    }
    for (int i=0; i<=G; ++i) {
      for (int j=0; j<=P; ++j) {
        for (int k=length-2; k>-1; --k) {
          if (group[k] > i) {
            dp[i][j][k] = dp[i][j][k+1];
          } else {
            dp[i][j][k] = dp[i][j][k+1] + dp[i-group[k]][Math.max(0, j-profit[k])][k+1];
          }
          // in case of overflow
          dp[i][j][k] %= mod;
        }
      }
    }
    return dp[G][P][0];
  }

  public static void main(String[] args) {
    ProfitableSchemes p = new ProfitableSchemes();
/*
    int G = 10;
    int P = 5;
    int[] group = new int[]{2, 3, 5};
    int[] profit = new int[]{6, 7, 8};
*/
    int G = 100;
    int P = 100;
    int[] group = new int[]{2,5,36,2,5,5,14,1,12,1,14,15,1,1,27,13,6,59,6,1,7,1,2,7,6,1,6,1,3,1,2,11,3,39,21,20,1,27,26,22,11,17,3,2,4,5,6,18,4,14,1,1,1,3,12,9,7,3,16,5,1,19,4,8,6,3,2,7,3,5,12,6,15,2,11,12,12,21,5,1,13,2,29,38,10,17,1,14,1,62,7,1,14,6,4,16,6,4,32,48};
    int[] profit = new int[]{21,4,9,12,5,8,8,5,14,18,43,24,3,0,20,9,0,24,4,0,0,7,3,13,6,5,19,6,3,14,9,5,5,6,4,7,20,2,13,0,1,19,4,0,11,9,6,15,15,7,1,25,17,4,4,3,43,46,82,15,12,4,1,8,24,3,15,3,6,3,0,8,10,8,10,1,21,13,10,28,11,27,17,1,13,10,11,4,36,26,4,2,2,2,10,0,11,5,22,6};
    int result = p.profitableSchemes(G, P, group, profit);
    System.out.println(result);

  }
}
