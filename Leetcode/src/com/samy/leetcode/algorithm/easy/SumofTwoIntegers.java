package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 9/2/16.
 * https://leetcode.com/problems/sum-of-two-integers/
 */
public class SumofTwoIntegers {

  public int getSum(int a, int b) {
    do {
      int c = a;
      a ^= b;
      b &= c;
      b <<= 1;
    } while (b != 0);
    return a;
  }

}
