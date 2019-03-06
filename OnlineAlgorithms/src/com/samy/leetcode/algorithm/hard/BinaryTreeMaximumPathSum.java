package com.samy.leetcode.algorithm.hard;

import com.samy.datastructure.TreeNode;


public class BinaryTreeMaximumPathSum {

  /**
   * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
   * @param root
   * @return
   */
  public int maxPathSum(TreeNode root) {
    int[] sum = helper(root);
    return sum != null ? Math.max(sum[0], sum[1]) : 0;
  }

  private int[] helper(TreeNode root) {
    if(root == null)
      return null;
    if(root.left==null && root.right==null)
      return new int[]{root.val, root.val};
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    int max;
    if(left == null) {
      max = Math.max(root.val, root.val+right[0]);
      return new int[]{max, Math.max(max, right[1])};
    }
    if(right == null) {
      max = Math.max(root.val, root.val+left[0]);
      return new int[]{max, Math.max(max, left[1])};
    }
    max = Math.max(root.val, Math.max(root.val+left[0], root.val+right[0]));
    return new int[]{max, maxValue(max, root.val+left[0]+right[0], left[1], right[1])};
  }

  private int maxValue(int... o) {
    int max = Integer.MIN_VALUE;
    for(int i: o) {
      if(i > max)
        max = i;
    }
    return max;
  }
}
