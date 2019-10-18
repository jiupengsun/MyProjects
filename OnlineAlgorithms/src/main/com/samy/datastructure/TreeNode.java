package com.samy.datastructure;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  /**
   * construct a binary tree by array
   *
   * @param n
   * @return
   */
  public static TreeNode constructBinaryTreeByArray(int[] n) {
    return constructSubTree(0, n);
  }

  /**
   * @param i
   * @param n
   * @return
   */
  private static TreeNode constructSubTree(int i, int[] n) {
    if (i >= n.length || n[i] < 0)
      return null;
    TreeNode tn = new TreeNode(n[i]);
    tn.left = constructSubTree((i << 1) + 1, n);
    tn.right = constructSubTree((i << 1) + 2, n);
    return tn;
  }

  public void print() {
    System.out.println(val);
  }
}
