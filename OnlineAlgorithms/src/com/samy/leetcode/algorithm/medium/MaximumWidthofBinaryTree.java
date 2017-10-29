package com.samy.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

  /**
   * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
   * @param root
   * @return
   */
  public int widthOfBinaryTree(TreeNode root) {
    int max=0, st=1, en=0;
    Queue<TreeNode> que = new LinkedList<>();
    Queue<Integer> id = new LinkedList<>();
    if(root != null) {
      que.add(root);
      que.add(null);
      id.add(1);
    }
    while(!que.isEmpty()) {
      root = que.poll();
      if(root != null) {
        en = id.poll();
        if (root.left != null) {
          que.add(root.left);
          id.add(en << 1);
        }
        if (root.right != null) {
          que.add(root.right);
          id.add((en << 1) + 1);
        }
      } else {
        max = Math.max(max, en-st+1);
        if(que.isEmpty())
          return max;
        st = id.peek();
        que.add(null);
      }
    }
    return max;
  }
}
