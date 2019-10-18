package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ConstructBinaryTreefromString {

  /**
   * https://leetcode.com/problems/construct-binary-tree-from-string/description/
   *
   * @param s
   * @return
   */
  public TreeNode str2tree(String s) {
    if (s.equals(""))
      return null;
    int i = 0, j = 0, l = s.length();
    while (i < l) {
      if (s.charAt(i) == '(')
        break;
      ++i;
    }
    TreeNode root = null;
    if (i > 0)
      root = new TreeNode(Integer.parseInt(s.substring(0, i)));
    j = i;
    boolean isLeft = true;
    while (j < l) {
      Deque<Character> stack = new LinkedList<>();
      while (j < l) {
        char c = s.charAt(j);
        if (c == '(')
          stack.push(c);
        else if (c == ')') {
          stack.pop();
          if (stack.isEmpty()) {
            String subtree = s.substring(i + 1, j);
            if (isLeft) {
              root.left = str2tree(subtree);
              isLeft = false;
              i = j + 1;
              j = i;
              break;
            } else {
              root.right = str2tree(subtree);
              return root;
            }
          }
        }
        ++j;
      }
    }
    return root;
  }
}
