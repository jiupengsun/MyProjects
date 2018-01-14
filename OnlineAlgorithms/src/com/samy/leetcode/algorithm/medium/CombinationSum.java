package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  /**
   *
   * @param candidates
   * @param target
   * @return
   * 2016��2��23��
   * @author Jiupeng
   * @description 168 test cases, 8ms beats 53.94%
   * @reference https://leetcode.com/problems/combination-sum/
   * @interpretation
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    return helper(candidates, target, candidates.length - 1);
  }

  private List<List<Integer>> helper(int[] candidates, int target, int end) {
    List<List<Integer>> collection = new ArrayList<List<Integer>>();
    if (target == 0) {
      collection.add(new ArrayList<Integer>());
    } else {
      while (end >= 0 && target < candidates[end])
        --end;
      while (end > 0 && candidates[end - 1] == candidates[end])
        --end;
      if (end >= 0) {
        //get the total number of target
        int i = target / candidates[end];
        while (i >= 0) {
          List<List<Integer>> collectionSub = helper(candidates,
            target - i * candidates[end], end - 1);
          for (List<Integer> list : collectionSub) {
            for (int j = 0; j < i; ++j) {
              list.add(candidates[end]);
            }
            collection.add(list);
          }
          --i;
        }
      }
    }

    return collection;
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, 0, target, list, new ArrayList<>());
    return list;
  }

  private void helper(int[] candidates, int st, int target, List<List<Integer>> list, List<Integer> l) {
    if(target == 0) {
      list.add(new ArrayList<>(l));
      return;
    }
    if(st == candidates.length || candidates[st] > target)
      return;
    int k = target / candidates[st];
    for(int i=0; i<k; ++i)
      l.add(candidates[st]);
    while(k > 0) {
      helper(candidates, st+1, target-k*candidates[st], list, l);
      l.remove(l.size() - 1);
      --k;
    }
    helper(candidates, st+1, target-k*candidates[st], list, l);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] candidates = { 1, 2, 3 };
    int target = 6;
    CombinationSum cs = new CombinationSum();
    List<List<Integer>> collection = cs.combinationSum(candidates, target);
    System.out.println(collection);
  }

}
