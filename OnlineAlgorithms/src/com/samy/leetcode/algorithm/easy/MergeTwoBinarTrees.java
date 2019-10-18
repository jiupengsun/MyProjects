package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;


public class MergeTwoBinarTrees {
  /**
   * https://leetcode.com/problems/merge-two-binary-trees/description/
   *
   * @param t1
   * @param t2
   * @return
   */
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    return helper(t1, t2);
  }

  private TreeNode helper(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
      return null;
    if (t1 == null)
      return t2;
    if (t2 == null)
      return t1;
    int sum = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
    TreeNode root = new TreeNode(sum);
    root.left = helper(t1.left, t2.left);
    root.right = helper(t1.right, t2.right);
    return root;
  }
}
