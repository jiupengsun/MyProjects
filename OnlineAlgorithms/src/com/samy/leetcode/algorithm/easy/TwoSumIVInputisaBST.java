package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TwoSumIVInputisaBST {
  public boolean findTarget(TreeNode root, int k) {
    Map<Integer, Boolean> map = new HashMap<>();
    Deque<TreeNode> stack = new LinkedList<>();
    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(map.containsKey(k - root.val))
        return true;
      map.put(root.val, true);
      root = root.right;
    }
    return false;
  }
}
