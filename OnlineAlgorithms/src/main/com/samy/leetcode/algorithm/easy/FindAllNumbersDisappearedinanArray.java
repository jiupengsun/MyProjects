package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int tmp = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != i + 1 && nums[i] > 0) {
        int r = nums[i];
        nums[i] = 0;
        while (r > 0 && nums[r - 1] != r) {
          tmp = nums[r - 1];
          nums[r - 1] = r;
          r = tmp;
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != i + 1)
        list.add(i + 1);
    }
    return list;
  }
}
