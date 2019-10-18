package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

  /**
   * https://leetcode.com/problems/factor-combinations/description/
   *
   * @param n
   * @return
   */
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> list = new ArrayList<>();
    if (n == 1)
      return list;
    helper(n, 2, list, new ArrayList<>());
    if (!list.isEmpty())
      list.remove(list.size() - 1);
    return list;
  }

  private void helper(int n, int last, List<List<Integer>> list, List<Integer> l) {
    if (n == 1) {
      list.add(new ArrayList<>(l));
      return;
    }
    for (int i = last; i <= n; ++i) {
      if (n % i == 0) {
        l.add(i);
        helper(n / i, i, list, l);
        l.remove(l.size() - 1);
      }
    }
  }
}
