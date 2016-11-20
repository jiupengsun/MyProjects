package com.samy.leetcode.algorithm.easy;

import java.util.List;

/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 * Created by samy on 11/19/16.
 */
public class NestedListWeightSum {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for(NestedInteger nest : nestedList) {
      if(nest.isInteger())
        sum += depth * nest.getInteger();
      else {
        sum += depthSum(nest.getList(), depth+1);
      }
    }
    return sum;
  }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * */
interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

