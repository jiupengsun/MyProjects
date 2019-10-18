package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Set<List<Integer>> set = new HashSet<List<Integer>>();
    List<Integer> list1 = new ArrayList<Integer>();
    list1.add(1);
    List<Integer> list2 = new ArrayList<Integer>();
    set.add(list1);
    list2.add(2);
    set.add(list2);
    System.out.println(list1.equals(list2));
    System.out.println(set.size());
  }

  /**
   * @param nums
   * @return Apr 6, 2016
   * @author Jiupeng
   * @description 30 test cases, 20ms beats 21.68%
   * @reference https://leetcode.com/problems/permutations-ii/
   * @interpretation http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> perm = new ArrayList<List<Integer>>();
    perm.add(new ArrayList<Integer>());
    for (int i : nums) {
      Set<List<Integer>> set = new HashSet<List<Integer>>();
      for (List<Integer> list : perm) {
        for (int j = 0, l = list.size(); j <= l; ++j) {
          List<Integer> newL = new ArrayList<Integer>(list);
          newL.add(j, i);
          set.add(newL);
        }
      }
      perm = new ArrayList<List<Integer>>(set);
    }

    return perm;
  }

  public List<List<Integer>> permuteUnique2(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    helper(nums, 0, list);
    return list;
  }

  private void helper(int[] nums, int st, List<List<Integer>> list) {
    if (st == nums.length - 1) {
      List<Integer> l = new ArrayList<>(nums.length);
      for (int i : nums)
        l.add(i);
      list.add(l);
      return;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = st; i < nums.length; ++i) {
      if (!set.add(nums[i]))
        continue;
      swap(nums, st, i);
      helper(nums, st + 1, list);
      swap(nums, st, i);
    }
  }

  private void swap(int[] nums, int i, int j) {
    if (i != j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
  }

}
