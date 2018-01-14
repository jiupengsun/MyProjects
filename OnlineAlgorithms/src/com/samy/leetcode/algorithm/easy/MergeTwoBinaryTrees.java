package com.samy.leetcode.algorithm.easy;

public class MergeTwoBinaryTrees {

  /**
   * https://leetcode.com/problems/merge-two-binary-trees/description/
   * @param t1
   * @param t2
   * @return
   */
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if(t1==null && t2==null)
      return null;
    if(t1==null || t2==null)
      return t1 != null ? t1 : t2;
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }
}
