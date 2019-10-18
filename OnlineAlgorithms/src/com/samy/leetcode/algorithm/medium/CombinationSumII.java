package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  /**
   * @param candidates
   * @param target
   * @return 2016��2��24��
   * @author Jiupeng
   * @description 172 test cases, 6ms beats 70.29%
   * @reference https://leetcode.com/problems/combination-sum-ii/
   * @interpretation
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    return helper(candidates, target, candidates.length - 1);
  }

  private List<List<Integer>> helper(int[] candidates, int target, int end) {
    List<List<Integer>> collection = new ArrayList<List<Integer>>();
    if (target == 0)
      collection.add(new ArrayList<Integer>());
    else {
      while (end >= 0 && target < candidates[end])
        --end;
      if (end >= 0) {
        List<List<Integer>> colSub = helper(candidates,
          target - candidates[end], end - 1);
        for (List<Integer> list : colSub) {
          list.add(candidates[end]);
          collection.add(list);
        }
        while (end > 0 && candidates[end - 1] == candidates[end])
          --end;
        colSub = helper(candidates, target, end - 1);
        collection.addAll(colSub);
      }
    }
    return collection;
  }

  public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new ArrayList<>();
    boolean[] used = new boolean[candidates.length];
    helper(candidates, 0, target, list, used);
    return list;
  }

  private void helper(int[] candidates, int st, int target, List<List<Integer>> list, boolean[] used) {
    if (target == 0) {
      List<Integer> l = new ArrayList<>();
      for (int i = 0; i < st; ++i) {
        if (used[i])
          l.add(candidates[i]);
      }
      list.add(l);
      return;
    }
    if (st == candidates.length || candidates[st] > target)
      return;
    // use current value
    if (st == 0 || candidates[st] != candidates[st - 1] || used[st - 1]) {
      used[st] = true;
      helper(candidates, st + 1, target - candidates[st], list, used);
      used[st] = false;
    }
    // don't use current value
    helper(candidates, st + 1, target, list, used);
  }

}
