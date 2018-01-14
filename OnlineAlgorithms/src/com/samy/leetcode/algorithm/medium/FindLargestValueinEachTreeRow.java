package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class FindLargestValueinEachTreeRow {

  /**
   * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
   * @param root
   * @return
   */
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    Queue<TreeNode> que = new LinkedList<>();
    if(root != null) {
      que.add(root);
      que.add(null);
    }
    int max = Integer.MIN_VALUE;
    while(!que.isEmpty()) {
      root = que.poll();
      if(root != null) {
        if(root.val > max)
          max = root.val;
        if(root.left != null)
          que.add(root.left);
        if(root.right != null)
          que.add(root.right);
      } else {
        list.add(max);
        max = Integer.MIN_VALUE;
        if(!que.isEmpty())
          que.add(null);
      }
    }
    return list;
  }
}
