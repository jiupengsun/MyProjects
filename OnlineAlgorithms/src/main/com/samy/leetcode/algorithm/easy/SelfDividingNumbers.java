package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

  /**
   * https://leetcode.com/problems/self-dividing-numbers/description/
   *
   * @param left
   * @param right
   * @return
   */
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> list = new ArrayList<>();
    for (int i = left; i <= right; ++i) {
      if (isDN(i))
        list.add(i);
    }
    return list;
  }

  private boolean isDN(int i) {
    int n = i;
    while (i > 0) {
      int d = i % 10;
      if (d == 0 || n % d != 0)
        return false;
      i /= 10;
    }
    return true;
  }
}
