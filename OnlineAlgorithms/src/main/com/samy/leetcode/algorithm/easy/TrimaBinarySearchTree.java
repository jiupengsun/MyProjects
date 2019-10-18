package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;


public class TrimaBinarySearchTree {
  /**
   * https://leetcode.com/problems/trim-a-binary-search-tree/description/
   *
   * @param root
   * @param L
   * @param R
   * @return
   */
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null)
      return null;
    else if (root.val < L)
      return trimBST(root.right, L, R);
    else if (root.val > R)
      return trimBST(root.left, L, R);
    else {
      // root is between L and R
      root.left = trimBST(root.left, L, R);
      root.right = trimBST(root.right, L, R);
      return root;
    }
  }
}
