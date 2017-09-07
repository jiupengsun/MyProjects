package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 10/1/16.
 */
public class SumofLeftLeaves {

  /**
   * https://leetcode.com/problems/sum-of-left-leaves/
   * @param root
   * @return
   */
  public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
  }

  private int helper(TreeNode root, boolean isLeftChild) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null && isLeftChild) {
      return root.val;
    }
    return helper(root.left, true) + helper(root.right, false);
  }

  public int sumOfLeftLeaves2(TreeNode root) {
    int sum = 0;
    if(root == null)
      return sum;
    if(root.left!=null && root.left.left==null && root.left.right==null)
      sum += root.left.val;
    return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }

  public static void main(String[] args) {
  }
}
