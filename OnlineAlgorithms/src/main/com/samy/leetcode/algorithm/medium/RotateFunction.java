package com.samy.leetcode.algorithm.medium;

public class RotateFunction {

  /**
   * https://leetcode.com/problems/rotate-function/description/
   *
   * @param A
   * @return
   */
  public int maxRotateFunction(int[] A) {
    int total = 0, last = 0;
    for (int i = 0; i < A.length; ++i) {
      total += A[i];
      last += i * A[i];
    }
    int max = last;
    for (int i = A.length - 1; i > 0; --i) {
      last = last + total - A.length * A[i];
      max = Math.max(max, last);
    }
    return max;
  }
}
