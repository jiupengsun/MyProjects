package com.samy.leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-phone-directory/description/
 */
public class DesignPhoneDirectory {
}

class PhoneDirectory {
  Set<Integer> pool;
  int max, current;
  Queue<Integer> que;

  /**
   * Initialize your data structure here
   *
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    max = maxNumbers;
    current = 0;
    pool = new HashSet<>();
    que = new LinkedList<>();
  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    if (current < max) {
      pool.add(current);
      return current++;
    }
    // has used all numbers
    if (que.isEmpty())
      return -1;
    int num = que.poll();
    pool.add(num);
    return num;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    return !pool.contains(number);
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (pool.remove(number)) {
      que.add(number);
    }
  }
}
