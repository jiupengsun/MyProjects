package com.samy.leetcode.algorithm.medium;

import java.util.List;

public class NestedListWeightSumII {

  /**
   * https://leetcode.com/problems/nested-list-weight-sum-ii/description/
   *
   * @param nestedList
   * @return
   */
  public int depthSumInverse(List<NestedInteger> nestedList) {
    // find max depth
    int max_depth = 1;
    for (NestedInteger ni : nestedList) {
      if (!ni.isInteger()) {
        max_depth = Math.max(max_depth, findDepth(ni) + 1);
      }
    }
    // calculate sum
    return calculate(nestedList, max_depth);
  }

  private int findDepth(NestedInteger ni) {
    int max_depth = 0;
    if (ni.isInteger())
      return max_depth;
    for (NestedInteger n : ni.getList()) {
      max_depth = Math.max(max_depth, findDepth(n) + 1);
    }
    return max_depth;
  }

  private int calculate(List<NestedInteger> ni, int depth) {
    int sum = 0;
    for (NestedInteger n : ni) {
      if (n.isInteger())
        sum += n.getInteger() * depth;
      else {
        sum += calculate(n.getList(), depth - 1);
      }
    }
    return sum;
  }

}
