package com.samy.company.Uber;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KDistanceTree {

  public List<Integer> print(TreeNode root, TreeNode target, int k) {
    if(root == null)
      return new ArrayList<>();
    List<Integer> list = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    // false means left child
    // true means right
    Deque<Boolean> mark = new LinkedList<>();
    stack.push(root);
    mark.push(null);
    TreeNode tmp = null;
    Boolean flag = null;
    do {
      if(tmp == null) {
        tmp = stack.pop();
        flag = mark.pop();
      }
      // judge current state
      if(flag == null) {
        // new node
        if(tmp == target) {
          // find
          break;
        }
        if(tmp.left != null) {
          stack.push(tmp);
          mark.push(false);
          tmp = tmp.left;
        } else if(tmp.right != null) {
          stack.push(tmp);
          mark.push(true);
          tmp = tmp.right;
        } else {
          tmp = null;
        }
      } else if(!flag) {
        // back from left
        if(tmp.right != null) {
          stack.push(tmp);
          mark.push(true);
          tmp = tmp.right;
        } else
          tmp = null;
      } else {
        // back from right
        tmp = null;
      }
    } while(!stack.isEmpty());

    if(tmp == target) {
      // find
      getKthChild(target, k, list);
      int i = 1;
      while(!stack.isEmpty()) {
        tmp = stack.pop();
        flag = mark.pop();
        if(!flag) {
          // back from left
          getKthChild(tmp.right, k-i-1, list);
        } else
          getKthChild(tmp.left, k-i-1, list);
      }
    }
    return list;
  }

  private void getKthChild(TreeNode root, int k, List<Integer> list) {
    if(root == null)
      return;
    if(k == 0)
      list.add(root.val);
    getKthChild(root.left, k-1, list);
    getKthChild(root.right, k-1, list);
  }
}


class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int t) {
    val = t;
  }
}
