package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BoundaryofBinaryTree {

  /**
   * https://leetcode.com/problems/boundary-of-binary-tree/description/
   * @param root
   * @return
   */
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if(root == null)
      return list;
    // add root
    list.add(root.val);
    // add left boundary
    TreeNode left = root.left;
    while(left != null) {
      if(left.left!=null || left.right!=null)
        list.add(left.val);
      left = left.left!=null ? left.left : left.right;
    }
    // add leaf
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode tmp = root;
    while(tmp!=null || !stack.isEmpty()) {
      while(tmp != null) {
        stack.push(tmp);
        tmp = tmp.left;
      }
      tmp = stack.pop();
      if(tmp.left==null && tmp.right==null && tmp!=root)
        list.add(tmp.val);
      tmp = tmp.right;
    }
    // add right boundary
    TreeNode right = root.right;
    int pos = list.size();
    while(right != null) {
      if(right.left!=null || right.right!=null)
        list.add(pos, right.val);
      right = right.right!=null ? right.right : right.left;
    }
    return list;
  }
}
