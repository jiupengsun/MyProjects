package com.samy.leetcode.algorithm.easy;

public class ClosestBinarySearchTreeValue {

  /**
   * https://leetcode.com/problems/closest-binary-search-tree-value/description/
   * @param root
   * @param target
   * @return
   */
  public int closestValue(TreeNode root, double target) {
    double min = Long.MAX_VALUE;
    int val = root.val;
    while(true) {
      double diff = root.val - target;
      if(diff < 0) {
        if(min > -diff) {
          min = -diff;
          val = root.val;
        }
        if(root.right == null)
          break;
        root = root.right;
      } else if(diff > 0) {
        if(min > diff) {
          min = diff;
          val = root.val;
        }
        if(root.left == null)
          break;
        root = root.left;
      } else {
        val = root.val;
        break;
      }
    }
    return val;
  }
}
