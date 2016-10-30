package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * Created by samy on 10/24/16.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumIII {

  public int pathSum(TreeNode root, int sum) {
    return helper(root, sum, false);
  }

  private int helper(TreeNode root, int sum, boolean p) {
    int path = 0;
    if (root == null)
      return path;
    int diff = sum - root.val;
    if (p) {
      // if parent node was selected
      if (diff == 0)
        ++path;
      path += helper(root.left, diff, true) + helper(root.right, diff, true);
    } else {
      // if parent node wasn't selected
      if (diff == 0)
        ++path;
      // then choose or not choose this node
      path += helper(root.left, sum, false) + helper(root.right, sum, false);
      path += helper(root.left, diff, true) + helper(root.right, diff, true);

    }
    return path;
  }
}
