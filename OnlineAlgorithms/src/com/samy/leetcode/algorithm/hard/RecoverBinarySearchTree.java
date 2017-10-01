package com.samy.leetcode.algorithm.hard;

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
}
