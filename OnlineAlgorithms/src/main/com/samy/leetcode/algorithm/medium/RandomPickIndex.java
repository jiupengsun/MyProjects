package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class RandomPickIndex {

  private Map<Integer, List<Integer>> map;
  private int[] array;

  public RandomPickIndex(int[] nums) {
    array = nums;
    map = new HashMap<>();
  }

  public int pick(int target) {
    List<Integer> list = map.get(target);
    if (list == null) {
      list = new ArrayList<>();
      for (int i = 0; i < array.length; ++i) {
        if (array[i] == target)
          list.add(i);
      }
    }
    return list.get(new Random().nextInt(list.size()));
  }
}
