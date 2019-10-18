package com.samy.leetcode.algorithm.easy;

public class NumberComplement {

  /**
   * https://leetcode.com/problems/number-complement/description/
   *
   * @param num
   * @return
   */
  public int findComplement(int num) {
    return leftMost(num) ^ num;
  }

  private int leftMost(int num) {
    num |= num >> 1;
    num |= num >> 2;
    num |= num >> 4;
    num |= num >> 8;
    num |= num >> 16;
    return num;
  }
}
