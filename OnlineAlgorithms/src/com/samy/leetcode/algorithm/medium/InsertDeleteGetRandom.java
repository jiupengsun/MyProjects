package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
}

class RandomizedSet {

  private int capacity = 10000;
  private int[] array;
  private int pointer;
  private Map<Integer, Integer> map;

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
    array = new int[capacity];
    pointer = -1;
    map = new HashMap<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (map.containsKey(val))
      return false;
    array[++pointer] = val;
    return map.put(val, pointer) == null;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    Integer pos = map.get(val);
    if (pos == null)
      return false;
    if (pos != pointer) {
      swap(pos, pointer--);
      map.put(array[pos], pos);
    } else
      --pointer;
    map.remove(val);
    return true;
  }

  private void swap(int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    if (pointer >= 0) {
      return array[new Random().nextInt(pointer + 1)];
    }
    return 0;
  }
}
