package com.samy.algorithm;

import com.samy.datastructure.TreeNode;

/**
 * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */
public class MorrisTree {

  public void inOrderTraverse(TreeNode root) {
    while (root != null) {
      if (root.left == null) {
        root.print();
        root = root.right;
        continue;
      }
      // find precursor node
      TreeNode tmp = root.left;
      while (tmp.right != null && tmp.right != root)
        tmp = tmp.right;
      if (tmp.right == null) {
        tmp.right = root;
        root = root.left;
      } else {
        tmp.right = null;
        root.print();
        root = root.right;
      }
    }
  }

  public void preOrderTraverse(TreeNode root) {
    while(root != null) {
      if(root.left == null) {
        root.print();
        root = root.right;
        continue;
      }
      // find precursor node
      TreeNode tmp = root.left;
      while (tmp.right != null && tmp.right != root)
        tmp = tmp.right;
      if (tmp.right == null) {
        root.print();
        tmp.right = root;
        root = root.left;
      } else {
        tmp.right = null;
        root = root.right;
      }
    }
  }

  public void postOrderTraverse(TreeNode root) {
  }

  public static void main(String[] args) {

    TreeNode root = TreeNode.constructBinaryTreeByArray(new int[]{3,2,5,1,-1,4,6,-1,-1,-1,-1,-1,-1,-1,8});
    MorrisTree mt = new MorrisTree();
    mt.preOrderTraverse(root);
  }
}
