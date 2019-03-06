package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;


/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 */
public class SerializeandDeserializeBST {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null)
      return "";
    StringBuilder sb = new StringBuilder(root.val + ",");
    sb.append(serialize(root.left)).append(serialize(root.right));
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] s = data.split(",");
    int l = s.length;
    if(l < 1 || data.equals(""))
      return null;
    int[] d = new int[s.length];
    for(int i=0; i<l; ++i) {
      d[i] = Integer.parseInt(s[i]);
    }
    return helper(d, 0, l-1);
  }

  private TreeNode helper(int[] s, int st, int en) {
    if(st > en)
      return null;
    TreeNode root = new TreeNode(s[st]);
    int i=st+1;
    for(; i<=en; ++i) {
      if(s[i] > root.val)
        break;
    }
    root.left = helper(s, st+1, i-1);
    root.right = helper(s, i, en);

    return root;
  }
}
