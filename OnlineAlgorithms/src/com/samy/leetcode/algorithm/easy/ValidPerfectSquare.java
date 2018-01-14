package com.samy.leetcode.algorithm.easy;

public class ValidPerfectSquare {

  /**
   * https://leetcode.com/problems/valid-perfect-square/description/
   * @param num
   * @return
   */
  public boolean isPerfectSquare(int num) {
    long i=1, j=num, mid;
    while(i <= j) {
      mid = ((j - i) >> 1) + i;
      long sqrt = mid * mid;
      if(sqrt == num)
        return true;
      else if(sqrt < num)
        i = mid + 1;
      else
        j = mid - 1;
    }
    return false;
  }
}
