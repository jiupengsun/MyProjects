package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 * <p>
 * using binary index tree
 * reference:
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * http://www.cnblogs.com/pengzhen/p/4373491.html
 */
public class RangeSumQueryMutable {
}

class NumArray {
  int[] bit;
  int[] nums;

  public NumArray(int[] nums) {
    if (nums.length == 0)
      return;
    this.nums = nums;
    bit = new int[nums.length + 1];
    for (int i = 0; i < nums.length; ++i)
      plus(i + 1, nums[i]);
  }

  public void update(int i, int val) {
    int diff = val - nums[i];
    nums[i] = val;
    plus(i + 1, diff);
  }

  private void plus(int index, int n) {
    while (index < bit.length) {
      bit[index] += n;
      index += index & (-index);
    }
  }

  private int get(int index) {
    int sum = 0;
    while (index > 0) {
      sum += bit[index];
      index -= index & (-index);
    }
    return sum;
  }

  public int sumRange(int i, int j) {
    return get(j + 1) - get(i);
  }
}
