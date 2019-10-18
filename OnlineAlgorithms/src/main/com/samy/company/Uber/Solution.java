package com.samy.company.Uber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

  public static List<int[]> merge(List<int[]> inter1, List<int[]> inter2) {
    List<int[]> list = new ArrayList<>();
    int i = 0, j = 0;
    int l1 = inter1.size(), l2 = inter2.size();
    while (i < l1 && j < l2) {
      int[] i1 = inter1.get(i);
      int[] i2 = inter2.get(j);
      int max_start = Math.max(i1[0], i2[0]);
      int min_end = Math.min(i1[1], i2[1]);
      if (max_start < min_end) {
        // has intersection
        list.add(new int[]{max_start, min_end});
      }
      if (i1[1] < i2[1])
        ++i;
      else
        ++j;
    }

    return list;
  }

  public static List<int[]> union(List<int[]> inter1, List<int[]> inter2) {
    List<int[]> list = new ArrayList<>();
    int i = 0, j = 0;
    int l1 = inter1.size(), l2 = inter2.size();
    while (i < l1 && j < l2) {
      int[] i1 = inter1.get(i);
      int[] i2 = inter2.get(j);
      int max_start = Math.max(i1[0], i2[0]);
      int min_end = Math.min(i1[1], i2[1]);
      if (max_start < min_end) {
        // has intersection
        int[] cur = new int[]{Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
        if (list.size() > 0) {
          int[] last = list.get(list.size() - 1);
          if (last[1] > Math.min(i1[0], i2[0])) {
            list.remove(list.size() - 1);
            cur[0] = last[0];
          }
        }
        list.add(cur);
      } else {
        int[] early = i1[0] < i2[0] ? i1 : i2;
        int[] late = i1[0] < i2[0] ? i2 : i1;
        if (list.size() > 0) {
          int[] last = list.get(list.size() - 1);
          if (last[1] > early[0]) {
            list.remove(list.size() - 1);
            early[0] = last[0];
          }
        }
        list.add(early);
        list.add(late);
      }

      ++i;
      ++j;
    }
    int k = i;
    List<int[]> l = inter1;
    if (j < l2) {
      k = j;
      l = inter2;
    }

    while (k < l.size()) {
      int[] tmp = l.get(k);
      int[] last = list.get(list.size() - 1);
      if (last[1] > tmp[0])
        tmp = new int[]{last[0], Math.max(last[1], tmp[1])};
      list.add(tmp);
    }

    return list;
  }

  /**
   * http://www.1point3acres.com/bbs/thread-192483-1-1.html
   *
   * @param loginTime
   */
  public static void countLoginUsers(float[][] loginTime) {
    TreeMap<Float, Integer> map = new TreeMap<>();
    for (int i = 0; i < loginTime.length; ++i) {
      map.put(loginTime[i][0], map.getOrDefault(loginTime[i][0], 0) + 1);
      map.put(loginTime[i][1], map.getOrDefault(loginTime[i][1], 0) - 1);
    }
    int count = 0;
    for (Map.Entry<Float, Integer> m : map.entrySet()) {
      count += m.getValue();
      System.out.println(m.getKey() + " " + count);
    }
  }

  public static void specialSort(int[] A) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      max = Math.max(max, A[i]);
      min = Math.min(min, A[i]);
    }
    //Change all values to Positive
    for (int i = 0; i < A.length; i++)
      A[i] -= min;

    int newMax = max - min + 1;

    //Save original negative values into new positions
    int index = 0;
    for (int i : A)
      if (i % newMax < -min)
        A[index++] += (i % newMax) * newMax;
    //Save original positive values into new positions
    for (int i : A)
      if (i % newMax > -min)
        A[index++] += (i % newMax) * newMax;
    //Recover to original value
    for (int i = 0; i < A.length; i++) {
      A[i] = A[i] / newMax + min;
    }
  }

  /**
   * @param nums
   * @return
   */
  public static int max_get(int[] nums) {
    return helper(nums, 0, nums.length - 1, true);
  }

  private static int helper(int[] nums, int st, int en, boolean turn) {
    if (st == en)
      return turn ? nums[st] : 0;
    int left = helper(nums, st + 1, en, !turn);
    int right = helper(nums, st, en - 1, !turn);
    return turn ? Math.max(left + nums[st], right + nums[en])
             : Math.min(left, right);
  }

  public static void main(String[] args) {
    System.out.println(max_get(new int[]{5, 9, 3, 1}));
  }
}
