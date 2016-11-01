package com.samy.leetcode.algorithm.hard;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Created by samy on 11/1/16.
 */
public class PopulatingNextRightPointersinEachNodeII {

  /**
   * Definition for binary tree with next pointer.
   * public class TreeLinkNode {
   *     int val;
   *     TreeLinkNode left, right, next;
   *     TreeLinkNode(int x) { val = x; }
   * }
   */
  public class Solution {

    public void connect(TreeLinkNode root) {

      while(root != null) {

        // find the first node that has children
        while(root!=null && root.left==null && root.right==null)
          root = root.next;
        TreeLinkNode leftMost = root, last;

        if (root != null) {
          last = root.left != null ? root.left : root.right;
          while(root != null) {
            if (root.left!= null && root.left!=last) {
              last.next = root.left;
              last = last.next;
              continue;
            } else if (root.right!=null && root.right!=last) {
              last.next = root.right;
              last = root.right;
              root = root.next;
              continue;
            } else
              root = root.next;
          }
          root = leftMost.left != null ? leftMost.left : leftMost.right;
        }
      }
    }
  }
}

class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;

  TreeLinkNode(int x) {
    val = x;
  }
}
