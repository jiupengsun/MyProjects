package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLeavesofBinaryTree {

  /**
   * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
   *
   * @param root
   * @return
   */
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    helper(root, list);
    return list;
  }

  private int helper(TreeNode root, List<List<Integer>> list) {
    if (root == null)
      return 0;
    int max_depth = Math.max(helper(root.left, list), helper(root.right, list));
    List<Integer> l = null;
    if (max_depth >= list.size()) {
      l = new ArrayList<>();
      list.add(l);
    } else
      l = list.get(max_depth);
    l.add(root.val);
    return max_depth + 1;
  }
}
