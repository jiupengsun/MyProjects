package com.samy.leetcode.algorithm.easy;

public class HammingDistance {
  public int hammingDistance(int x, int y) {
    return count1s(x ^ y);
  }

  private int count1s(int x) {
    x = ((x & 0xAAAAAAAA) >> 1) + (x & 0x55555555);
    x = ((x & 0xCCCCCCCC) >> 2) + (x & 0x33333333);
    x = ((x & 0xF0F0F0F0) >> 4) + (x & 0x0F0F0F0F);
    x = ((x & 0xFF00FF00) >> 8) + (x & 0x00FF00FF);
    x = ((x & 0xFFFF0000) >> 16) + (x & 0x0000FFFF);
    return x;
  }
}
