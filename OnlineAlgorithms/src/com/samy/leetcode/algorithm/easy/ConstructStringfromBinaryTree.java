package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;


public class ConstructStringfromBinaryTree {

  /**
   * https://leetcode.com/problems/construct-string-from-binary-tree/description/
   * @param t
   * @return
   */
  public String tree2str(TreeNode t) {
    if(t == null)
      return "";
    StringBuilder sb = new StringBuilder("" + t.val);
    String left = tree2str(t.left);
    String right = tree2str(t.right);
    if(!left.equals("") || !right.equals("")) {
      sb.append("(" + left + ")");
      if(!right.equals(""))
        sb.append("(" + right + ")");
    }
    return sb.toString();
  }
}
