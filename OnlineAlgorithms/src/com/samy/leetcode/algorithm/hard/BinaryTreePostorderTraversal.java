package com.samy.leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Created by samy on 11/14/16.
 */
public class BinaryTreePostorderTraversal {

  class Node {
    int status = 0;
    TreeNode root;
    Node(TreeNode n, int s) {
      root = n;
      status = s;
    }
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<Node> stack = new Stack<>();
    stack.push(new Node(root, 0));
    while(!stack.isEmpty()) {
      Node r = stack.pop();
      if (r.status == 0) {
        // push left
        root = r.root;
        while(root != null) {
          stack.push(new Node(root, 1));
          root = root.left;
        }
      } else if (r.status == 1) {
        // push right
        r.status = 2;
        stack.push(r);
        root = root.right;
      } else {
        list.add(r.root.val);
      }
    }
    return null;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  /**
   *
   * @return
   * @author Jiupeng
   * @description construct a binary tree sample
   * 									6
   * 					2								8
   * 			0				4				7				9
   * 						3		5								10
   * 																		11
   * @reference
   */
  static TreeNode constructABinaryTreeSample() {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    root.right.right.right = new TreeNode(10);
    root.right.right.right.right = new TreeNode(11);
    return root;
  }

  /**
   *
   * @param n
   * @return
   * @author Jiupeng
   * @description construct a binary tree according to the array
   * the element of array should meet the position of a complete binary tree, and equal -1 if the node is null
   * @reference
   */
  static TreeNode constructABinaryTreeSampleByArray(int[] n) {
    return constructSubTree(0, 0, n);
  }

  private static TreeNode constructSubTree(int h, int i, int[] n) {
    if (i >= n.length || n[i] < 0)
      return null;
    TreeNode tn = new TreeNode(n[i]);
    tn.left = constructSubTree(h + 1, 2 * i + 1, n);
    tn.right = constructSubTree(h + 1, 2 * i + 2, n);
    return tn;
  }

  /**
   *
   * @param root
   * @author Jiupeng
   * @description print a binary tree with inorder traversal
   * @reference
   */
  static void printBinaryTreeInorderTraversal(TreeNode root) {
    if (root == null)
      return;
    System.out.print(root.val + " ");
    printBinaryTreeInorderTraversal(root.left);
    printBinaryTreeInorderTraversal(root.right);
  }
}
