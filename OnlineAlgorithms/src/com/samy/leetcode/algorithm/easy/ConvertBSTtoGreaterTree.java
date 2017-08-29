package com.samy.leetcode.algorithm.easy;

public class ConvertBSTtoGreaterTree {

  private int sum = 0;

  /**
   * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
   * @param root
   * @return
   */
  public TreeNode convertBST(TreeNode root) {
    if(root == null)
      return null;
    convertBST(root.right);
    root.val += sum;
    sum = root.val;
    convertBST(root.left);
    return root;
  }

}
