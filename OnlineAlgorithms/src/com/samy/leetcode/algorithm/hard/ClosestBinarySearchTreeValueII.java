package com.samy.leetcode.algorithm.hard;

import com.samy.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueII {

  /**
   * https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    // in-order traverse to get a sorted list
    List<Integer> list = new LinkedList<>();
    if(root == null)
      return list;
    Deque<TreeNode> stack = new LinkedList<>();
    while(root!=null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      list.add(root.val);
      root = root.right;
    }
    // find a number larger k
    int length = list.size(), j = 0;
    for(; j<length; ++j) {
      if(list.get(j) >= target)
        break;
    }
    List<Integer> l = new ArrayList<>(length);
    int i = j-1;
    while(k-- > 0) {
      if(i < 0)
        l.add(list.get(j++));
      else if(j == length)
        l.add(list.get(i--));
      else if(target - list.get(i) < list.get(j) - target)
        l.add(list.get(i--));
      else
        l.add(list.get(j++));
    }
    return l;
  }
}
