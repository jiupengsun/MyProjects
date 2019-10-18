package com.samy.leetcode.algorithm.easy;

import com.samy.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> list = new ArrayList<>();
    if (root == null) return list;
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    que.add(null);
    double sum = 0d;
    int count = 0;
    while (!que.isEmpty()) {
      TreeNode n = que.poll();
      if (n != null) {
        sum += n.val;
        count++;
        if (n.left != null) que.add(n.left);
        if (n.right != null) que.add(n.right);
      } else {
        list.add(sum / count);
        sum = 0d;
        count = 0;
        if (!que.isEmpty())
          que.add(null);
      }
    }
    return list;
  }
}
