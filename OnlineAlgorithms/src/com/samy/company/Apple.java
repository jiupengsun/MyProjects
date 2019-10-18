package com.samy.company;

public class Apple {

  /**
   * naive solution
   *
   * @return
   */
  public TreeNode constructBST(TreeNode root) {
    // find a leaf node to replace current root
    // use root to construct BST
    while (root != null) {
      TreeNode tmp = root.left != null ? root.left : root.right;
      if (tmp == null) {
        // only root left
        // use root
        break;
      }
      if (tmp.left == null && tmp.right == null) {
        // tmp is a leaf node
      }
      TreeNode prev = tmp;
      tmp = tmp.left != null ? tmp.left : tmp.right;
      while (tmp.left != null || tmp.right != null) {
        prev = tmp;
        tmp = tmp.left != null ? tmp.left : tmp.right;
      }
      // tmp is leaf not
      if (prev.left == tmp)
        prev.left = null;
      else if (prev.right == tmp)
        prev.right = null;
      tmp.left = root.left;
      tmp.right = root.right;
      root.left = null;
      root.right = null;
      // use root
    }
    return null;
  }

  /**
   * Morris Tree
   *
   * @return
   */
  public TreeNode constructBST2() {
    return null;
  }
}

class TreeNode {
  int val;
  TreeNode left, right;

  TreeNode(int v) {
    val = v;
  }
}
