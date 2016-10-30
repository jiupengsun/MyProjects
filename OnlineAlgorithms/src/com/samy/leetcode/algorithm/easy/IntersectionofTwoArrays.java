package com.samy.leetcode.algorithm.easy;

import java.util.*;

/**
 * Created by samy on 9/3/16.
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionofTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {

    Set<Integer> set = new HashSet<>();
    for (int i : nums1)
      set.add(i);
    Set<Integer> set2 = new HashSet<>();
    for (int i : nums2) {
      if (set.contains(i))
        set2.add(i);
    }
    int[] intersect = new int[set2.size()];
    Iterator<Integer> iter = set2.iterator();
    int i = 0;
    while (iter.hasNext()) {
      intersect[i++] = iter.next();
    }
    return intersect;
  }

}
