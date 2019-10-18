package com.samy.leetcode.algorithm.hard;

import com.samy.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
public class SerializeandDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> que = new LinkedList<>();
    if (root != null)
      que.add(root);
    while (!que.isEmpty()) {
      root = que.poll();
      if (root != null) {
        sb.append(root.val + ",");
        que.add(root.left);
        que.add(root.right);
      } else {
        sb.append("*,");
      }
    }
    // remove trace * and ,
    int i = sb.length() - 1;
    for (; i >= 0; --i) {
      char c = sb.charAt(i);
      if (c != ',' && c != '*')
        break;
    }
    return i >= 0 ? sb.substring(0, i + 1) : "";
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals(""))
      return null;
    String[] array = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(array[0]));
    int i = 1;
    TreeNode tmp = root;
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
      tmp = que.poll();
      if (i < array.length) {
        String leftS = array[i++];
        if (!leftS.equals("*")) {
          TreeNode left = new TreeNode(Integer.parseInt(leftS));
          que.add(left);
          tmp.left = left;
        }
      }
      if (i < array.length) {
        String rightS = array[i++];
        if (!rightS.equals("*")) {
          TreeNode right = new TreeNode(Integer.parseInt(rightS));
          que.add(right);
          tmp.right = right;
        }
      }

    }
    return root;
  }

}
