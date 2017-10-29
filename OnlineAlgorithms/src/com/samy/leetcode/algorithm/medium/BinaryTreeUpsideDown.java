package com.samy.leetcode.algorithm.medium;

public class BinaryTreeUpsideDown {

  /**
   * https://leetcode.com/problems/binary-tree-upside-down/description/
   * @param root
   * @return
   */
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if(root == null)
      return null;
    TreeNode last = root, right = root.right;
    last.right = null;
    root = root.left;
    last.left = null;
    while(root != null) {
      TreeNode tmpLast = last;
      TreeNode rightTmp = right;
      TreeNode left = root.left;
      right = root.right;
      root.left = rightTmp;
      root.right = tmpLast;
      last = root;
      root = left;
    }

    return last;
  }
}
