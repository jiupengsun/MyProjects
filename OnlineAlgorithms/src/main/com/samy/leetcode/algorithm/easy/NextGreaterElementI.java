package com.samy.leetcode.algorithm.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0)
      return nums1;
    int[] res = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new LinkedList<>();
    map.put(nums2[nums2.length - 1], -1);
    stack.push(nums2[nums2.length - 1]);
    for (int i = nums2.length - 2; i >= 0; --i) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i])
        stack.pop();
      map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums2[i]);
    }
    for (int i = 0; i < nums1.length; ++i)
      res[i] = map.get(nums1[i]);
    return res;
  }
}
