package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {

  /**
   * https://leetcode.com/problems/distribute-candies/description/
   * @param candies
   * @return
   */
  public int distributeCandies(int[] candies) {
    Map<Integer, Boolean> map = new HashMap<>();
    for(int i: candies) {
      map.put(i, true);
    }
    return Math.min(candies.length >> 1, map.size());
  }
}
