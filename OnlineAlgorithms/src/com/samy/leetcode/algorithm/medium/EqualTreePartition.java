package com.samy.leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

public class EqualTreePartition {

  /**
   * https://leetcode.com/problems/equal-tree-partition/description/
   * @param root
   * @return
   */
  public boolean checkEqualTree(TreeNode root) {
    if(root == null || (root.left==null && root.right==null))
      return false;
    Set<Integer> set = new HashSet<>();
    int total = getSum(root, set);
    if((total & 1) == 1)
      return false;
    return set.contains(total>>1);
  }

  private int getSum(TreeNode root, Set<Integer> set) {
    if(root == null)
      return 0;
    int left = getSum(root.left, set);
    int right = getSum(root.right, set);
    int sum = root.val + left + right;
    set.add(sum);
    return sum;
  }}
