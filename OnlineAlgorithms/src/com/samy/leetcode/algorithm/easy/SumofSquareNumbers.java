package com.samy.leetcode.algorithm.easy;

public class SumofSquareNumbers {

  /**
   * https://leetcode.com/problems/sum-of-square-numbers/description/
   * @param c
   * @return
   */
  public boolean judgeSquareSum(int c) {
    int i=0, j=(int)Math.sqrt(c);
    while(i <= j) {
      int sum = i*i + j*j;
      if(sum == c)
        return true;
      else if(sum < c)
        ++i;
      else
        --j;
    }
    return false;
  }
}
