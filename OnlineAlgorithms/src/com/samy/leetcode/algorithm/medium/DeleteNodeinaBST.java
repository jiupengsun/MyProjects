package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;


public class DeleteNodeinaBST {

  /**
   * https://leetcode.com/problems/delete-node-in-a-bst/description/
   *
   * @param root
   * @param key
   * @return
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val == key)
      return delete(root);
    // find the target node
    TreeNode parent = root, child = key > root.val ? root.right : root.left;
    while (child != null && child.val != key) {
      parent = child;
      child = child.val > key ? child.left : child.right;
    }
    if (child == null)
      return root;
    if (key > parent.val)
      parent.right = delete(child);
    else
      parent.left = delete(child);
    return root;
  }

  private TreeNode delete(TreeNode root) {
    if (root.left == null || root.right == null)
      return root.left != null ? root.left : root.right;
    // find the larget node in left child
    TreeNode tmp = root.left;
    if (tmp.right == null) {
      tmp.right = root.right;
      return tmp;
    }
    while (tmp.right.right != null) {
      tmp = tmp.right;
    }
    TreeNode right = tmp.right;
    tmp.right = right.left;
    right.left = root.left;
    right.right = root.right;
    return right;
  }
}
