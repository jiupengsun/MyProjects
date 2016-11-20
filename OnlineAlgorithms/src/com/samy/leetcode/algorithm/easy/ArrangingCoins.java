package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/arranging-coins/
 * Created by samy on 11/19/16.
 */
public class ArrangingCoins {

  public int arrangeCoins(int n) {
    int i=0, j=n, mid;
    while(i<=j) {
      // in case of overflowing
      mid = i + ((j-i) >> 1);
      if ( (mid+1.0)*mid*0.5 <= n) {
        i = mid + 1;
      } else {
        j = mid - 1;
      }
    }
    return j;
  }

  /**
   * TLE
   * @param n
   * @return
   */
  public int arrangeCoins2(int n) {
    int i=(int)Math.sqrt(n), t=(n+i)>>1;
    while(true) {
      if(t > n)
        return i-1;
      t += ++i;
    }
  }

  public static void main(String[] args) {
    int i = Integer.MAX_VALUE;
    int sqrt = (int)Math.sqrt(i);
    int mid = i>>1;
    System.out.println(1.0*mid*mid);
    System.out.println((mid+1)*mid/2.0);
  }
}
