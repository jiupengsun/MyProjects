package com.samy.leetcode.algorithm.hard;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

  /**
   * https://leetcode.com/problems/sliding-window-maximum/description/
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[]{};
    Deque<Integer> que = new LinkedList<>();
    int i = 0, j = 0;
    int[] max = new int[nums.length - k + 1];
    while (i < nums.length) {
      while (!que.isEmpty() && que.peek() < i - k + 1) {
        que.poll();
      }
      while (!que.isEmpty() && nums[que.peekLast()] <= nums[i])
        que.pollLast();
      que.add(i);
      if (i >= k - 1)
        max[j++] = nums[que.peek()];
      ++i;
    }

    return max;
  }
}
