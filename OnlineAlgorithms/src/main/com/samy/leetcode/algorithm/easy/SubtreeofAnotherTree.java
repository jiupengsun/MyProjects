package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;


public class SubtreeofAnotherTree {

  /**
   * https://leetcode.com/problems/subtree-of-another-tree/description/
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null && t == null)
      return true;
    if (s == null || t == null)
      return false;
    if (s.val == t.val && judge(s, t))
      return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean judge(TreeNode s, TreeNode t) {
    if (s == null && t == null)
      return true;
    if (s == null || t == null)
      return false;
    return s.val == t.val && judge(s.left, t.left) && judge(s.right, t.right);
  }
}
