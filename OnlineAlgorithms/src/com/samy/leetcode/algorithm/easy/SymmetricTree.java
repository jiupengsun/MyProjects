package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SymmetricTree s = new SymmetricTree();
    int[] n = {1, 2, 2, -1, 3, -1, 3};
    TreeNode tn = TreeNode.constructBinaryTreeByArray(n);
    System.out.println(s.isSymmetric(tn));
  }

  /**
   * @param root
   * @return 2016��1��14��
   * @author Jiupeng
   * @description
   * @reference https://leetcode.com/problems/symmetric-tree/
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return compareBinaryTree(root.left, root.right);
  }

  /**
   * @param root
   * @return 2016��1��14��
   * @author Jiupeng
   * @description Using queue to fulfill this task without recursion
   * @reference
   */
  public boolean isSymmetricByIteration(TreeNode root) {
    if (root == null)
      return true;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root.left);
    q.add(root.right);
    while (q.size() != 0) {
      TreeNode left = q.poll();
      TreeNode right = q.poll();
      if (left == right)
        continue;
      if (left == null || right == null || left.val != right.val)
        return false;
      q.add(left.left);
      q.add(right.right);
      q.add(left.right);
      q.add(right.left);
    }
    return true;
  }

  /**
   * @param t1
   * @param t2
   * @return 2016��1��14��
   * @author Jiupeng
   * @description compare if two trees are exactly the mirror, including both of values and structure
   * @reference
   */
  private boolean compareBinaryTree(TreeNode t1, TreeNode t2) {
    if (t1 == t2)
      return true;
    if (t1 == null || t2 == null)
      return false;
    return t1.val == t2.val && compareBinaryTree(t1.left, t2.right) && compareBinaryTree(t1.right, t2.left);

  }

  public boolean isSymmetric2(TreeNode root) {
    if (root == null)
      return true;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.push(root.left);
    stack.push(root.right);
    while (!stack.isEmpty()) {
      TreeNode left = stack.pop();
      TreeNode right = stack.pop();
      if (left == null && right == null)
        continue;
      if (left == null || right == null || left.val != right.val)
        return false;
      stack.push(left.left);
      stack.push(right.right);
      stack.push(left.right);
      stack.push(right.left);
    }
    return true;
  }

}
