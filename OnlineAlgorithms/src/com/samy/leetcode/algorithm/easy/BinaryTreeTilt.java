package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;

public class BinaryTreeTilt {
  public int findTilt(TreeNode root) {
    if(root == null)
      return 0;
    return helper(root)[1];
  }

  private int[] helper(TreeNode root) {
    if(root == null)
      return new int[]{0, 0};
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    int diff = Math.abs(left[0] - right[0]);
    return new int[]{left[0]+right[0]+root.val, left[1]+right[1]+diff};
  }
}
