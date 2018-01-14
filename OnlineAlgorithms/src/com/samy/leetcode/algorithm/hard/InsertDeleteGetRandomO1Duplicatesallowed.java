package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 */
public class InsertDeleteGetRandomO1Duplicatesallowed {}

class RandomizedCollection {
  Map<Integer, Set<Integer>> map;
  List<Integer> list;

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    map = new HashMap<>();
    list = new ArrayList<>(1000);
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    Set<Integer> set = map.get(val);
    boolean flag = false;
    if(set == null) {
      // LinkedHashSet provides better performance than HashSet when iterating
      // it depends the size, not the capacity, which did by HashSet
      set = new LinkedHashSet<>();
      flag = true;
    }
    set.add(list.size());
    map.put(val, set);
    list.add(val);
    return flag;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    Set<Integer> set = map.get(val);
    if(set == null)
      return false;
    int index = set.iterator().next();
    set.remove(index);
    if(index == list.size() - 1) {
      // last digit
      list.remove(index);
    } else {
      // swap
      int tail = list.remove(list.size() - 1);
      Set<Integer> lastSet = map.get(tail);
      lastSet.remove(list.size());
      lastSet.add(index);
      map.put(tail, lastSet);
      list.set(index, tail);
    }
    if(set.isEmpty())
      map.remove(val);
    else
      map.put(val, set);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return list.get(new Random().nextInt(list.size()));
  }
}
