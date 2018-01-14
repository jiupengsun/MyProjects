package com.samy.leetcode.algorithm.easy;

public class BinaryNumberwithAlternatingBits {
  /**
   * https://leetcode.com/problems/binary-number-with-alternating-bits/
   * @param n
   * @return
   */
  public boolean hasAlternatingBits(int n) {
    int tmp = n;
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;
    return tmp==(n & 0x55555555) || tmp==(n & 0xAAAAAAAA);
  }
}
