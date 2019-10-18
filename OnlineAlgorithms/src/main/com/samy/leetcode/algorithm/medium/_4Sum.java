package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {

  /**
   * @param nums
   * @param target
   * @return
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new LinkedList<>();
    for (int i = 0; i < nums.length - 3; ++i) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      List<List<Integer>> l3 = threeSum(nums, i + 1, target - nums[i]);
      for (List<Integer> l : l3) {
        l.add(nums[i]);
        list.add(l);
      }
    }
    return list;
  }

  private List<List<Integer>> threeSum(int[] nums, int st, int target) {
    List<List<Integer>> list = new LinkedList<>();
    for (int i = st; i < nums.length - 2; ++i) {
      if (i > st && nums[i] == nums[i - 1])
        continue;
      List<List<Integer>> l2 = twoSum(nums, i + 1, target - nums[i]);
      for (List<Integer> l : l2) {
        l.add(nums[i]);
        list.add(l);
      }
    }
    return list;
  }

  private List<List<Integer>> twoSum(int[] nums, int st, int target) {
    List<List<Integer>> list = new LinkedList<>();
    int i = st, j = nums.length - 1;
    while (i < j) {
      if (i > st && nums[i] == nums[i - 1]) {
        ++i;
        continue;
      }
      int sum = nums[i] + nums[j];
      if (sum == target) {
        List<Integer> l2 = new ArrayList<>(2);
        l2.add(nums[i++]);
        l2.add(nums[j--]);
        list.add(l2);
      } else if (sum < target)
        ++i;
      else
        --j;
    }
    return list;
  }
}
