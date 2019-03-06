package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;


public class SecondMinimumNodeInaBinaryTree {

  /**
   *
   * @param root
   * @return
   */
  public int findSecondMinimumValue(TreeNode root) {
    if(root == null || root.left == null)
      return -1;
    // has two children
    if(root.left.val == root.right.val) {
      if(root.left.val == root.val) {
        int left = findSecondMinimumValue(root.left);
        int right = findSecondMinimumValue(root.right);
        if(left<0 && right < 0)
          return -1;
        if(left<0 || right < 0)
          return Math.max(left, right);
        return Math.min(left, right);
      }
      return root.left.val;
    } else {
      // not equal
      if(root.left.val==root.val || root.right.val==root.val) {
        if(root.left.val == root.val) {
          int left = findSecondMinimumValue(root.left);
          return left == -1 ? root.right.val : Math.min(left, root.right.val);
        } else {
          int right = findSecondMinimumValue(root.right);
          return right == -1 ? root.left.val : Math.min(right, root.left.val);
        }
      }
      // both children has different value with root
      // then must be less one of them
      return Math.min(root.left.val, root.right.val);
    }
  }
}
