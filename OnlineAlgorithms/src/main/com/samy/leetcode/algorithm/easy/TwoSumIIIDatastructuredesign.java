package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 */
public class TwoSumIIIDatastructuredesign {
}

class TwoSum {
  Map<Integer, Boolean> map = new HashMap<>();

  /**
   * Initialize your data structure here.
   */
  public TwoSum() {

  }

  /**
   * Add the number to an internal data structure..
   */
  public void add(int number) {
    Boolean exist = map.get(number);
    if (exist == null)
      map.put(number, false);
    else if (!exist)
      map.put(number, true);
  }

  /**
   * Find if there exists any pair of numbers which sum is equal to the value.
   */
  public boolean find(int value) {
    for (int i : map.keySet()) {
      int diff = value - i;
      Boolean exist = map.get(diff);
      if (exist != null && (diff != i || exist))
        return true;
    }
    return false;
  }
}
