package com.samy.leetcode.algorithm.hard;

import com.samy.datastructure.TreeNode;


public class RecoverBinarySearchTree {

  TreeNode prev = null;
  TreeNode second = null;
  TreeNode last = null;

  /**
   * https://leetcode.com/problems/recover-binary-search-tree/description/
   *
   * @param root
   */
  public void recoverTree(TreeNode root) {
    inOrderTraverse(root);

    int tmp = prev.val;
    prev.val = second.val;
    second.val = tmp;
  }

  private void inOrderTraverse(TreeNode root) {
    if (root == null)
      return;
    inOrderTraverse(root.left);
    if (last != null && last.val > root.val) {
      if (prev == null) {
        // first inversion
        prev = last;
        second = root;
      } else {
        // second inversion
        second = root;
        return;
      }
    }
    last = root;
    inOrderTraverse(root.right);
  }

  /**
   * Use morris tree to solve this problem
   *
   * @param root
   */
  public void recoverTreeByMorris(TreeNode root) {
    TreeNode prev = null, second = null, last = null;
    while (root != null) {
      if (last != null && last.val > root.val) {
        if (prev == null) {
          prev = last;
          second = root;
        } else {
          second = root;
        }
      }
      if (root.left == null) {
        last = root;
        root = root.right;
        continue;
      }
      // find precursor node
      TreeNode tmp = root.left;
      while (tmp.right != null && tmp.right != root) {
        tmp = tmp.right;
      }
      if (tmp.right == null) {
        tmp.right = root;
        root = root.left;
      } else {
        tmp.right = null;
        last = root;
        root = root.right;
      }
    }
    int tmp = prev.val;
    prev.val = second.val;
    second.val = tmp;
  }
}
