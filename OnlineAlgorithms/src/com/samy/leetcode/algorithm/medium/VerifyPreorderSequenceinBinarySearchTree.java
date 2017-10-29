package com.samy.leetcode.algorithm.medium;

public class VerifyPreorderSequenceinBinarySearchTree {

  /**
   * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/description/
   * @param preorder
   * @return
   */
  public boolean verifyPreorder(int[] preorder) {
    return helper(preorder, 0, preorder.length-1);
  }

  private boolean helper(int[] preorder, int st, int en) {
    if(st >= en)
      return true;
    // first is root
    int root = preorder[st];
    // find first number larger than root
    int i = st + 1;
    while(i <= en && preorder[i] < root) {
      ++i;
    }
    if(i == en)
      return true;
    int j = i;
    // check if the following number is larger than root
    while(i <= en) {
      if(preorder[i] < root)
        return false;
      ++i;
    }
    // check sub tree
    return helper(preorder, st+1, j-1) && helper(preorder, j, en);
  }
}
