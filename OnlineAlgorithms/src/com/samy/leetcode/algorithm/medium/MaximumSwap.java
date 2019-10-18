package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSwap {

  /**
   * https://leetcode.com/problems/maximum-swap/discuss/
   *
   * @param num
   * @return
   */
  public int maximumSwap(int num) {
    List<Integer> list = new ArrayList<>(10);
    PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    int ori = num;
    while (num > 0) {
      int d = num % 10;
      list.add(d);
      que.add(d);
      num /= 10;
    }
    Integer[] array = new Integer[list.size()];
    list.toArray(array);
    for (int i = array.length - 1; i > 0; --i) {
      int d = que.poll();
      if (array[i] < d) {
        // find one
        for (int j = 0; j < i; ++j) {
          if (array[j] == d) {
            swap(array, i, j);
            break;
          }
        }
        int n = 0;
        for (int j = array.length - 1; j >= 0; --j)
          n = n * 10 + array[j];
        return n;
      }
    }
    return ori;
  }

  private void swap(Integer[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
