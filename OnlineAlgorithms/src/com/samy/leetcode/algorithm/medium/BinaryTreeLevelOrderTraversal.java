package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

  /**
   * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    Queue<TreeNode> que = new LinkedList<>();
    if(root != null) {
      que.add(root);
      que.add(null);
    }
    List<Integer> l = new LinkedList<>();
    while(!que.isEmpty()) {
      root = que.poll();
      if(root != null) {
        l.add(root.val);
        if(root.left != null)
          que.add(root.left);
        if(root.right != null)
          que.add(root.right);
      } else {
        list.add(l);
        l = new LinkedList<>();
        if(!que.isEmpty())
          que.add(null);
      }
    }
    return list;
  }
}
