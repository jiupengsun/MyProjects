package com.samy.leetcode.algorithm.easy;

public class _1bitand2bitCharacters {
  public boolean isOneBitCharacter(int[] bits) {
    int ones = 0;
    for (int i = bits.length - 2; i >= 0 && bits[i] > 0; --i)
      ones++;
    return (ones & 1) == 0;
  }
}
