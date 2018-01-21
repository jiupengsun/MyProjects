package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumAbsoluteDifferenceinBST {
  // in-order traversal
  public int getMinimumDifference(TreeNode root) {
    if(root == null) return 0;
    int last = -1, min = Integer.MAX_VALUE;
    Deque<TreeNode> stack = new LinkedList<>();
    while(root!=null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(last >= 0)
        min = Math.min(root.val - last, min);
      last = root.val;
      root = root.right;
    }
    return min;
  }
}
